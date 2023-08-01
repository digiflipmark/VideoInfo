package com.example.videoinfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.videoinfo.R
import com.example.videoinfo.data.model.ArticleJson


class AdListAdapter(var list: MutableList<ArticleJson>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var newassignList: MutableList<ArticleJson> = mutableListOf()

    init {
        if (list.size > 0) {

            var pos = 0
            for (i in list.indices) {
                if (pos == 3) {
                    val articleJson = ArticleJson()
                    articleJson.isAd = true
                    newassignList.add(articleJson)
                    pos = 0
                }

                val articleJson: ArticleJson = list[i]
                articleJson.isAd = false
                newassignList.add(articleJson)
                pos++
            }
        }
        this.list = newassignList
    }

    class OtherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_love = view.findViewById<ImageView>(R.id.iv_love)
    }

    class ExtraViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val iv_secon = view.findViewById<TextView>(R.id.iv_secon)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list.get(position)

        when (holder) {
            is OtherViewHolder -> {
                holder.iv_love.load(item.titel)

            }
            is ExtraViewHolder -> {

                holder.iv_secon.text =
                    "Change getItemViewType(int position) to use the isAd flag to distinguish the AD_TYPE from Item CONTENT_TYPE like below:"
            }
        }
    }


    override fun getItemCount(): Int {

        return list.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {


        return when (viewType) {
            R.layout.love_items -> {
                OtherViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.love_items, parent, false)
                )
            }

            R.layout.item_button -> {
                ExtraViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_button, parent, false)
                )
            }
            else -> {
                throw IllegalArgumentException("invliad")
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        val articleJson: ArticleJson = list.get(position)
        return if (articleJson.isAd == true) {
            R.layout.item_button
        } else {
            R.layout.love_items
        }
    }

}