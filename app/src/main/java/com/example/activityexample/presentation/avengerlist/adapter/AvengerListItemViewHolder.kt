package com.example.activityexample.presentation.avengerlist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.activityexample.R
import com.example.activityexample.base.ViewHolderBinder
import com.example.activityexample.data.model.Avenger
import com.example.activityexample.databinding.ItemAvengerBinding

class AvengerListItemViewHolder(
    private val binding: ItemAvengerBinding,
    private val listener: OnItemClickedListener<Avenger>
) : ViewHolder(binding.root),
    ViewHolderBinder<Avenger> {
    override fun bind(item: Avenger) {
        item.let {
            binding.ivAvengerPhoto.load(it.profilePictUrl) {
                crossfade(true)
                error(R.mipmap.ic_launcher)
            }
            binding.tvAvengerName.text = it.name
            binding.tvAvengerPower.text = it.power

            itemView.setOnClickListener {
                listener.onItemClicked(item)
            }
        }
    }
}