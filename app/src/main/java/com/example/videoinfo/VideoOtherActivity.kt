package com.example.videoinfo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.videoinfo.adapter.OtherListAdapter
import com.example.videoinfo.data.Resource
import com.example.videoinfo.data.model.DataItem
import com.example.videoinfo.data.model.OtherModel
import com.example.videoinfo.data.model.Person
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class VideoOtherActivity : AppCompatActivity() {

    val otherViemodel: VideoViemodel by viewModels()
    lateinit var otherListAdapter: OtherListAdapter
    lateinit var mylist: MutableList<DataItem>

    @SuppressLint("NotifyDataSetChanged", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_other)

        otherViemodel.fetchOtherCategories(85)
        otherViemodel.otherList.observe(this@VideoOtherActivity) {
            when (it) {
                is Resource.Error -> {

                }
                is Resource.Loading -> {}
                is Resource.NetworkError -> {

                }
                is Resource.Success -> {

                    val gridlayout = GridLayoutManager(this, 2)
                    gridlayout.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                        override fun getSpanSize(position: Int): Int {

                            return when (otherListAdapter.getItemViewType(position)) {
                                R.layout.item_button -> 2
                                R.layout.love_items -> 1
                                else -> {
                                    -1
                                }
                            }


                        }

                    }

                    findViewById<RecyclerView>(R.id.rv_details).layoutManager = gridlayout
                    mylist = it.data?.data!!
                    otherListAdapter = OtherListAdapter(this,mylist)

                    findViewById<RecyclerView>(R.id.rv_details).adapter = otherListAdapter


                }
            }
        }


    }


}