package mohsin.reza.nrlapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mohsin.reza.nrlapp.AppExecutors
import mohsin.reza.nrlapp.R
import mohsin.reza.nrlapp.Util.RetryCallback
import mohsin.reza.nrlapp.Util.autoCleared
import mohsin.reza.nrlapp.binding.FragmentDataBindingComponent
import mohsin.reza.nrlapp.databinding.StatFragmentBinding
import mohsin.reza.nrlapp.depinjection.Injectable
import mohsin.reza.nrlapp.model.Status
import mohsin.reza.nrlapp.model.TopPlayer
import mohsin.reza.nrlapp.ui.adapters.MatchAdapter
import mohsin.reza.nrlapp.ui.adapters.TopPlayerAdapter
import javax.inject.Inject

class MatchFragment : Fragment(), Injectable, TopPlayerAdapter.OnPlayerClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    @VisibleForTesting
    var binding by autoCleared<StatFragmentBinding>()

    private var adapter by autoCleared<MatchAdapter>()


    lateinit var matchViewModel: MatchViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.stat_fragment, container, false, dataBindingComponent)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        matchViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(MatchViewModel::class.java)

        val propertyAdapter = MatchAdapter(dataBindingComponent, appExecutors, this)
        binding.matchList.adapter = propertyAdapter //setting adapter for recyclerList
        this.adapter = propertyAdapter

        binding.swiperefresh.setOnRefreshListener {
            matchViewModel.setRefresh(true) //To reload data from network otherwise it will just show existing data
            // from viewModel
            getLiveDataFromViewModel()
        }

        matchViewModel.setRefresh(false) //This is not a refresh call. So will make network call if data is empty
        binding.callback = object : RetryCallback {
            override fun retry() {
                matchViewModel.setRefresh(true)
            }
        }
        binding.loadingStatus = true           //To show Progress bar during data load

        getLiveDataFromViewModel()
    }

    private fun getLiveDataFromViewModel() {
        matchViewModel.matchLiveData.observe(this, Observer { resourceRows ->
            binding.resource = resourceRows
            binding.loadingStatus = (Status.LOADING == resourceRows?.status ?: false)

            if (resourceRows?.data != null) {
                adapter.submitList(resourceRows.data)
            } else {
                adapter.submitList(emptyList())
            }

            if (binding.swiperefresh.isRefreshing) {
                binding.swiperefresh.isRefreshing = false
            }
        })
    }

    override fun onPlayerClicked(topPlayer: TopPlayer?, teamid: Int?) {
        val playerFragment = PlayerFragment.getIntance(topPlayer, teamid)
        val container = R.id.container
        var fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        val existing = fragmentManager?.findFragmentById(container)

        if (existing == null) {
            fragmentTransaction?.add(container, playerFragment, playerFragment.javaClass.name)
        } else
        {
            fragmentTransaction?.replace(container, playerFragment, playerFragment.javaClass.name)
            fragmentTransaction?.addToBackStack(existing.javaClass.name);
        }
        fragmentTransaction?.commitAllowingStateLoss()
    }
}