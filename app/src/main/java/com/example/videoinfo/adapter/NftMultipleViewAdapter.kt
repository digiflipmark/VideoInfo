/*
 * Copyright (c) Stephen Muindi @2023
 * on 28/03/2023 9:09 PM
 */

package com.steve_md.nftapp.ui.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.videoinfo.R
import com.example.videoinfo.data.model.VideoPojo

class NftMultipleViewAdapter : ListAdapter<VideoPojo, NftMultipleViewHolder>(NftCallBack()) {

    class NftCallBack : DiffUtil.ItemCallback<VideoPojo>() {
        override fun areItemsTheSame(oldItem: VideoPojo, newItem: VideoPojo): Boolean {
            return when {
                oldItem is VideoPojo.DataItem && newItem is VideoPojo.DataItem -> {
                    oldItem.id == newItem.id
                }
                oldItem is VideoPojo.TrendItem && newItem is VideoPojo.TrendItem -> {
                    oldItem.id == newItem.id
                }
                else -> {
                    false
                }
            }
        }

        override fun areContentsTheSame(oldItem: VideoPojo, newItem: VideoPojo): Boolean {
            return when {
                oldItem is VideoPojo.DataItem && newItem is VideoPojo.DataItem -> {
                    oldItem == newItem
                }

                oldItem is VideoPojo.TrendItem && newItem is VideoPojo.TrendItem -> {
                    oldItem == newItem
                }
                else -> {
                    false
                }
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NftMultipleViewHolder {
        return when (viewType) {

            R.layout.titel_lay -> NftMultipleViewHolder.TopTitelViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.titel_lay, parent, false)
            )

            R.layout.list_item -> NftMultipleViewHolder.TitleViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
            )

            R.layout.trend_items -> NftMultipleViewHolder.FeaturedViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.trend_items, parent, false)
            )

            else -> throw IllegalArgumentException("Invalid view type")


        }

    }

    override fun onBindViewHolder(holder: NftMultipleViewHolder, position: Int) {

        val item = getItem(position)
        when (holder) {
            is NftMultipleViewHolder.FeaturedViewHolder -> {

                val data = item as VideoPojo.TrendItem
                holder.iv_trends.load(data.thumb)
                holder.iv_trends.setOnClickListener {

                    itemClickListener?.invoke(holder.adapterPosition)
                }
            }
            is NftMultipleViewHolder.TitleViewHolder -> {

                val dataa = item as VideoPojo.DataItem
                holder.iv_image.load(dataa.icon)

                holder.iv_image.setOnClickListener {

                    itemClickListener?.invoke(holder.adapterPosition)
                }
            }
            is NftMultipleViewHolder.TopTitelViewHolder -> {

                val titel = item as VideoPojo.Titel
                holder.txt_featured.text = titel.titel
                holder.txt_viewAll.text = titel.viewAll
            }
        }
    }

    override fun getItemViewType(position: Int): Int {

        return when (getItem(position)) {
            is VideoPojo.DataItem -> R.layout.list_item
            is VideoPojo.TrendItem -> R.layout.trend_items
            is VideoPojo.Titel -> R.layout.titel_lay
        }
    }

    var itemClickListener: ((pos: Int) -> Unit)? = null
    fun setOnClickListner(listener: ((pos: Int) -> Unit)) {
        itemClickListener = listener
    }

}