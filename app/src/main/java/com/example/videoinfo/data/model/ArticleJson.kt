package com.example.videoinfo.data.model

data class ArticleJson(
    val data: String? = null,
    val titel: String? = null,
    var isAd: Boolean? = false
) {

    constructor() : this(null, null, null)
}
