package mohsin.reza.nrlapp.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mohsin.reza.nrlapp.AppExecutors
import mohsin.reza.nrlapp.R
import mohsin.reza.nrlapp.Util.autoCleared
import mohsin.reza.nrlapp.binding.FragmentDataBindingComponent
import mohsin.reza.nrlapp.databinding.PlayerFragmentBinding
import mohsin.reza.nrlapp.depinjection.Injectable
import mohsin.reza.nrlapp.model.CustomStat
import mohsin.reza.nrlapp.model.LastMatchStat
import mohsin.reza.nrlapp.model.Player
import mohsin.reza.nrlapp.model.TopPlayer
import mohsin.reza.nrlapp.ui.adapters.PlayerAdapter
import javax.inject.Inject

class PlayerFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    @VisibleForTesting
    var binding by autoCleared<PlayerFragmentBinding>()

    private var adapter by autoCleared<PlayerAdapter>()


    lateinit var playerViewModel: PlayerViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.player_fragment, container, false, dataBindingComponent)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        playerViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(PlayerViewModel::class.java)
        val playerId = arguments?.getInt("First")
        val teamidId = arguments?.getInt("Second")

        val playerAdapter = PlayerAdapter(dataBindingComponent, appExecutors)
        binding.lstatList.adapter = playerAdapter
        this.adapter = playerAdapter

        playerViewModel.setRefresh(playerId, teamidId)

        getLiveDataFromViewModel()
    }

    private fun getLiveDataFromViewModel() {
        playerViewModel.playerLiveData.observe(this, Observer { resourceRows ->

            if (resourceRows?.data != null) {
                binding.player = resourceRows.data
                val lastMatchStat: LastMatchStat? = resourceRows.data.lastMatchStat

                //TODO: Need to debug
                val clazz = lastMatchStat!!::class.java
                val customList= mutableListOf<CustomStat>()
                clazz.fields.forEach{
                    customList.add(CustomStat(it.name,it.getInt(it.name)))
                }
                adapter.submitList(customList)
            } else {
                adapter.submitList(emptyList())
            }
        })
    }
    companion object {
        fun getIntance(topPlayer:TopPlayer?, teamid:Int?): PlayerFragment
        {
            val playerFragment = PlayerFragment()
            val bundle = Bundle()
            bundle.putInt("First", topPlayer?.id?:0)
            bundle.putInt("Second", teamid?:0)
            playerFragment.arguments = bundle
            return playerFragment
        }
    }
}