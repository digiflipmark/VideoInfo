package com.example.videoinfo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.videoinfo.data.Resource
import com.steve_md.nftapp.ui.recyclerview.NftMultipleViewAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mainViemodel: VideoViemodel by viewModels()
    lateinit var nftMultipleViewAdapter: NftMultipleViewAdapter


    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grid = GridLayoutManager(this, 2)
        grid.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (nftMultipleViewAdapter.getItemViewType(position)) {
                    R.layout.titel_lay -> 2
                    R.layout.list_item -> 1
                    R.layout.trend_items -> 2

                    else -> {
                        -1
                    }
                }
            }

        }
        findViewById<RecyclerView>(R.id.rv).layoutManager = grid
        nftMultipleViewAdapter = NftMultipleViewAdapter()
        findViewById<RecyclerView>(R.id.rv).adapter = nftMultipleViewAdapter
        nftMultipleViewAdapter.setOnClickListner { pos ->
            val currentList = nftMultipleViewAdapter.currentList.toMutableList()
            if (pos>=0){
                currentList.removeAt(pos)
                nftMultipleViewAdapter.submitList(currentList)
            }

        }

        mainViemodel.fetchVideoCategories()
        mainViemodel.videoList.observe(this) {

            when (it) {
                is Resource.Success -> {
                    findViewById<ProgressBar>(R.id.pb).isVisible = false
                    nftMultipleViewAdapter.submitList(it.data)

                }
                is Resource.Error -> {
                    findViewById<ProgressBar>(R.id.pb).isVisible = false

                }
                is Resource.Loading -> {
                    findViewById<ProgressBar>(R.id.pb).isVisible = true

                }
                is Resource.NetworkError -> {

                }
            }
        }
    }


}

