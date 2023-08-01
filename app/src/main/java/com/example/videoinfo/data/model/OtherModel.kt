package com.example.videoinfo.data.model

data class OtherModel(
    val statusCode: Int,
    val data: MutableList<DataItem>,
    val totalRecords: Int,
    val totalPages: Int,
    val message: String,
    val currentPage: Int,
    val status: String
) {


}

data class DataItem(
    val mp3Url: String? = null,
    val thumb: String? = null,
    val name: String? = null,
    val mp3FileSize: Int? = null,
    val id: Int? = null,
    val video: String? = null,
    val viewCounter: Int? = null,
    val fileSize: Int? = null,
    var isAd: Boolean? = false,
    var isSelected: Boolean = false
) {

    constructor() : this(null, null, null, null, null, null, null, null, null)
}

