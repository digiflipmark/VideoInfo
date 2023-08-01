package com.example.videoinfo.data.model

import com.google.gson.annotations.SerializedName

sealed class VideoPojo {


    data class Titel(val titel: String, val viewAll: String):VideoPojo()

    data class VideoCategoriesPojo(

        @field:SerializedName("status_code")
        val statusCode: Int,

        @field:SerializedName("data")
        val data: MutableList<DataItem>,

        @field:SerializedName("total_records")
        val totalRecords: Int,

        @field:SerializedName("total_pages")
        val totalPages: Int,

        @field:SerializedName("message")
        val message: String,

        @field:SerializedName("current_page")
        val currentPage: Int,

        @field:SerializedName("status")
        val status: String
    )

    data class DataItem(

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("icon")
        val icon: String,

        @field:SerializedName("id")
        val id: Int
    ) : VideoPojo()

    data class TrendModel(

        @field:SerializedName("status_code")
        val statusCode: Int,

        @field:SerializedName("data")
        val data: MutableList<TrendItem>,

        @field:SerializedName("total_records")
        val totalRecords: Int,

        @field:SerializedName("total_pages")
        val totalPages: Int,

        @field:SerializedName("message")
        val message: String,

        @field:SerializedName("current_page")
        val currentPage: Int,

        @field:SerializedName("status")
        val status: String
    )

    data class TrendItem(

        @field:SerializedName("mp3_url")
        val mp3Url: String,

        @field:SerializedName("thumb")
        val thumb: String,

        @field:SerializedName("name")
        val name: String,

        @field:SerializedName("mp3_file_size")
        val mp3FileSize: Int,

        @field:SerializedName("id")
        val id: Int,

        @field:SerializedName("video")
        val video: String,

        @field:SerializedName("view_counter")
        val viewCounter: Int,

        @field:SerializedName("file_size")
        val fileSize: Int

    ) : VideoPojo()


}