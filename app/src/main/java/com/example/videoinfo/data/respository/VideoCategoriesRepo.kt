package com.example.videoinfo.data.respository

import com.example.videoinfo.data.Resource
import com.example.videoinfo.data.model.OtherModel
import com.example.videoinfo.data.model.VideoPojo

interface VideoCategoriesRepo {

    suspend fun fetchVideoCategories(
        token: String,
        packages: String,
        type: String,
        language_id: String
    ): Resource<VideoPojo.VideoCategoriesPojo>

    suspend fun fetchTrendCategories(
        token: String,
        packages: String,
        category: String,
        page: String,
        search: String,
        latest: String,
        language_id: String
    ): Resource<VideoPojo.TrendModel>


    suspend fun fetchOtherCategories(
        token: String,
        packages: String,
        category: String,
        page: String,
        search: String,
        latest: String,
        language_id: String
    ): Resource<OtherModel>


}