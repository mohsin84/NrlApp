package mohsin.reza.nrlapp.ui.adapters

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import mohsin.reza.nrlapp.AppExecutors
import mohsin.reza.nrlapp.R
import mohsin.reza.nrlapp.Util.DataBoundListAdapter
import mohsin.reza.nrlapp.databinding.LastMatchStatItemBinding
import mohsin.reza.nrlapp.model.CustomStat
import mohsin.reza.nrlapp.model.LastMatchStat

class PlayerAdapter(
        private val dataBindingComponent: DataBindingComponent,
        private val appExecutors: AppExecutors
) : DataBoundListAdapter<CustomStat, LastMatchStatItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<CustomStat>() {
            override fun areItemsTheSame(oldItem: CustomStat, newItem: CustomStat): Boolean {
                return false
            }

            override fun areContentsTheSame(oldItem: CustomStat, newItem: CustomStat): Boolean {
                return false
            }
        }
) {
    override fun createBinding(parent: ViewGroup): LastMatchStatItemBinding {
        val binding = DataBindingUtil.inflate<LastMatchStatItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.last_match_stat_item,
                parent,
                false,
                dataBindingComponent
        )
        return binding
    }

    override fun bind(binding: LastMatchStatItemBinding, lastMatchStat: CustomStat) {
        binding.customstat = lastMatchStat
    }
}