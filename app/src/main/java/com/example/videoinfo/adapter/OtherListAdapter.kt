package com.example.videoinfo.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.ActionMode
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.videoinfo.R
import com.example.videoinfo.VideoOtherActivity
import com.example.videoinfo.data.model.DataItem

class OtherListAdapter(val context: VideoOtherActivity, var items: MutableList<DataItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val newlist: MutableList<DataItem> = mutableListOf()
    var checkpos = 0  /*0 = is 1st position and -1 = no default selection */
    var actionMode: ActionMode? = null
    var isEnable = false

    init {

        /*if (items.isNotEmpty()) {

            var adpos = 0
            for (i in items.indices) {

                if (adpos == 2) {
                    val list = DataItem()
                    list.isAd = true
                    newlist.add(list)
                    adpos = 0
                }

                val dataItem: DataItem = items[i]
                dataItem.isAd = false
                newlist.add(dataItem)
                adpos++
            }

        }


        this.items = newlist*/
    }


    class OtherViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iv_love = view.findViewById<ImageView>(R.id.iv_love)
        val iv_chekd = view.findViewById<ImageView>(R.id.iv_chekd)
    }

    class ExtraViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val iv_secon = view.findViewById<TextView>(R.id.iv_secon)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items.get(position)

        when (holder) {

            is OtherViewHolder -> {
                val dd = item
                holder.iv_love.load(dd.thumb)


                holder.iv_chekd.isVisible = item.isSelected


                holder.iv_love.setOnClickListener {

                    if (actionMode != null) {

                        if (item.isSelected) {
                            item.isSelected = false
                            holder.iv_chekd.isVisible = false
                            newlist.remove(items.get(position))

                        } else {
                            item.isSelected = true
                            holder.iv_chekd.isVisible = true
                            newlist.add(items.get(position))

                        }


                        /* var total = 0

                         for (data in items) {
                             if (data.isSelected) {
                                 total++
                             }
                         }

                         actionMode?.title = "selected ${total}"*/
                    }

                }


                holder.iv_love.setOnLongClickListener {
                    if (actionMode == null) {
                        actionMode = context.startSupportActionMode(actionCallback)
                    }

                    if (item.isSelected) {
                        item.isSelected = false
                        holder.iv_chekd.isVisible = false
                        newlist.remove(items.get(position))

                    } else {
                        item.isSelected = true
                        holder.iv_chekd.isVisible = true
                        newlist.add(items.get(position))

                    }


                    /* var total = 0

                     for (data in items) {
                         if (data.isSelected) {
                             total++
                         }
                     }*/


                    /*actionMode?.title = "selected ${total}"*/
                    true
                }


            }
            is ExtraViewHolder -> {

                val dd = item
                holder.iv_secon.text = "Mehul"

            }
        }
    }


    override fun getItemCount(): Int {

        return items.size
    }

    var itemclickDelete: ((pos: Int) -> Unit)? = null
    var itemSelecation: ((selected: Boolean) -> Unit)? = null
    fun setOnclick(clickDelete: ((pos: Int) -> Unit)) {
        this.itemclickDelete = clickDelete
    }

    fun setOnItemSelection(item: ((selected: Boolean) -> Unit)) {
        this.itemSelecation = item
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
        return R.layout.love_items
    }


    /*override fun getItemViewType(position: Int): Int {
        *//* return when ((data?.get(position))) {
             is AnotherPojo.Banner -> R.layout.item_button
             is OtherItem -> R.layout.love_items
             else -> {
                 -1
             }
         }*//*



    }*/

    val actionCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return true
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            if (item?.itemId == R.id.aa) {
                for (i in newlist) {

                    if (i.isSelected) {
                        items.remove(i)
                        notifyDataSetChanged()
                    }
                }
                actionMode?.finish()
            }
            return true
        }

        override fun onDestroyActionMode(mode: ActionMode?) {
            for (i in items) {
                i.isSelected = false
                notifyDataSetChanged()
                actionMode = null
            }


        }

    }


}