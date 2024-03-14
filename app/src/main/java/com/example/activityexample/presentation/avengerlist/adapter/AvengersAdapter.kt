package com.example.activityexample.presentation.avengerlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.activityexample.base.ViewHolderBinder
import com.example.activityexample.data.model.Avenger
import com.example.activityexample.databinding.ItemAvengerBinding
import com.example.activityexample.databinding.ItemAvengerGridBinding

class AvengersAdapter(private val listMode: Int = MODE_LIST) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val MODE_LIST = 0
        const val MODE_GRID = 1
    }

    private var asyncDataDiffer = AsyncListDiffer(
        this,
        object : DiffUtil.ItemCallback<Avenger>() {
            override fun areItemsTheSame(oldItem: Avenger, newItem: Avenger): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: Avenger, newItem: Avenger): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (listMode == MODE_GRID) {
            AvengerGridItemViewHolder(
                ItemAvengerGridBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            AvengerListItemViewHolder(
                ItemAvengerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = asyncDataDiffer.currentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder !is ViewHolderBinder<*>) return
        (holder as ViewHolderBinder<Avenger>).bind(asyncDataDiffer.currentList[position])
    }

}