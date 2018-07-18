package mohsin.reza.nrlapp.ui.adapters

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import mohsin.reza.nrlapp.AppExecutors
import mohsin.reza.nrlapp.R
import mohsin.reza.nrlapp.Util.DataBoundListAdapter
import mohsin.reza.nrlapp.databinding.TopPlayerItemBinding
import mohsin.reza.nrlapp.model.TopPlayer

class TopPlayerAdapter(
        private val dataBindingComponent: DataBindingComponent,
        appExecutors: AppExecutors,
        private var listener: OnPlayerClickListener,
        private var teamid: Int?
) : DataBoundListAdapter<TopPlayer, TopPlayerItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<TopPlayer>() {
            override fun areItemsTheSame(oldItem: TopPlayer, newItem: TopPlayer): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TopPlayer, newItem: TopPlayer): Boolean {
                return oldItem.shortName == newItem.shortName && oldItem.shortName == newItem.shortName
            }
        }
) {
    override fun createBinding(parent: ViewGroup): TopPlayerItemBinding {
        val binding = DataBindingUtil.inflate<TopPlayerItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.top_player_item,
                parent,
                false,
                dataBindingComponent
        )
        binding.root.setOnClickListener { view ->
            listener.onPlayerClicked(binding.topPlayer, teamid)
        }
        return binding
    }

    override fun bind(binding: TopPlayerItemBinding, topPlayer: TopPlayer) {
        binding.topPlayer = topPlayer
    }

    interface OnPlayerClickListener {
        fun onPlayerClicked(topPlayer: TopPlayer?, teamid: Int?)
    }
}