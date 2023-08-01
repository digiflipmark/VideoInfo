/*
 * Copyright (c) Stephen Muindi @2023
 */

package com.steve_md.nftapp.ui.recyclerview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.videoinfo.R


sealed class NftMultipleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    class TopTitelViewHolder(view: View) : NftMultipleViewHolder(view) {
        val txt_featured =view.findViewById<TextView>(R.id.txt_featured)
        val txt_viewAll =view.findViewById<TextView>(R.id.txt_viewAll)

    }

    class TitleViewHolder(view: View) : NftMultipleViewHolder(view) {
        val iv_image =view.findViewById<ImageView>(R.id.iv_image)

    }

    class FeaturedViewHolder(view: View) : NftMultipleViewHolder(view) {
        val iv_trends =view.findViewById<ImageView>(R.id.iv_trends)
    }


}
