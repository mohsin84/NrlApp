package mohsin.reza.nrlapp.ui.adapters

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import mohsin.reza.nrlapp.AppExecutors
import mohsin.reza.nrlapp.R
import mohsin.reza.nrlapp.Util.DataBoundListAdapter
import mohsin.reza.nrlapp.databinding.MatchItemBinding
import mohsin.reza.nrlapp.model.Match

class MatchAdapter(
        private val dataBindingComponent: DataBindingComponent,
        private val appExecutors: AppExecutors,
        private var listener: TopPlayerAdapter.OnPlayerClickListener
) : DataBoundListAdapter<Match, MatchItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<Match>() {
            override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean {
                return oldItem.matchId == newItem.matchId
            }

            override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean {
                return oldItem.statType == newItem.statType && oldItem.statType == newItem.statType
            }
        }
) {
    override fun createBinding(parent: ViewGroup): MatchItemBinding {
        val binding = DataBindingUtil.inflate<MatchItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.match_item,
                parent,
                false,
                dataBindingComponent
        )
        return binding
    }

    override fun bind(binding: MatchItemBinding, match: Match) {
        binding.match = match

        var teamaAdapter = TopPlayerAdapter(dataBindingComponent, appExecutors, listener, match.teamA?.id)
        binding.teamAList.adapter = teamaAdapter
        teamaAdapter.submitList(match.teamA?.topPlayers)

        var teambAdapter = TopPlayerAdapter(dataBindingComponent, appExecutors, listener, match.teamB?.id)
        binding.teamBList.adapter = teambAdapter
        teambAdapter.submitList(match.teamB?.topPlayers)
    }
}