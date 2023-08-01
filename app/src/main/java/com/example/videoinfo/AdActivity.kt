package com.example.videoinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.videoinfo.adapter.AdListAdapter
import com.example.videoinfo.data.model.ArticleJson

class AdActivity : AppCompatActivity() {

    var list: MutableList<ArticleJson> = mutableListOf()
    lateinit var adListAdapter: AdListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ad)


        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16656625/pexels-photo-16656625.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "one"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "one"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "one"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "one"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "one"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "one"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "one"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "one"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "nine"
            )
        )
        list.add(
            ArticleJson(
                "https://images.pexels.com/photos/16189170/pexels-photo-16189170.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                "ten"
            )
        )

        val grid = GridLayoutManager(this, 2)
        grid.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (adListAdapter.getItemViewType(position)) {
                    R.layout.item_button -> 1
                    R.layout.love_items -> 1

                    else -> {
                        -1
                    }
                }
            }

        }
        findViewById<RecyclerView>(R.id.rv_ad).layoutManager = grid
        adListAdapter = AdListAdapter(list)
        findViewById<RecyclerView>(R.id.rv_ad).adapter = adListAdapter
    }
}