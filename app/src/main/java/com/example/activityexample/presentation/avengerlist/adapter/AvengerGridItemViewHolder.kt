package com.example.activityexample.presentation.avengerlist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.activityexample.R
import com.example.activityexample.base.ViewHolderBinder
import com.example.activityexample.data.model.Avenger
import com.example.activityexample.databinding.ItemAvengerGridBinding

class AvengerGridItemViewHolder(private val binding: ItemAvengerGridBinding) :
    ViewHolder(binding.root),
    ViewHolderBinder<Avenger> {
    override fun bind(item: Avenger) {
        item.let {
            binding.ivAvengerPhoto.load(it.profilePictUrl) {
                crossfade(true)
                error(R.mipmap.ic_launcher)
            }
            binding.tvAvengerName.text= it.name
        }
    }
}