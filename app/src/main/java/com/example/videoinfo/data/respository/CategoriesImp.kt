package com.example.videoinfo.data.respository

import com.example.videoinfo.data.Resource
import com.example.videoinfo.data.VideoApi
import com.example.videoinfo.data.model.OtherModel
import com.example.videoinfo.data.model.VideoPojo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoriesImp(private val videoApi: VideoApi) : VideoCategoriesRepo {

    override suspend fun fetchVideoCategories(
        token: String,
        packages: String,
        type: String,
        language_id: String
    ): Resource<VideoPojo.VideoCategoriesPojo> {

        return withContext(Dispatchers.IO) {

            try {
                val response = videoApi.videoCategories(token, packages, type, language_id)
                if (response.isSuccessful && response.body() != null) {
                    Resource.Success(response.body()!!)
                } else {
                    Resource.Error(response.message())
                }

            } catch (e: Exception) {
                Resource.Error(e.message.toString())
            }
        }

    }

    override suspend fun fetchTrendCategories(
        token: String,
        packages: String,
        category: String,
        page: String,
        search: String,
        latest: String,
        language_id: String
    ): Resource<VideoPojo.TrendModel> {
        return withContext(Dispatchers.IO) {

            try {
                val trendresponse = videoApi.TrendCategories(
                    token,
                    packages,
                    category,
                    page,
                    search,
                    latest,
                    language_id
                )
                if (trendresponse.isSuccessful && trendresponse.body() != null) {
                    Resource.Success(trendresponse.body()!!)
                } else {
                    Resource.Error(trendresponse.message())
                }

            } catch (e: Exception) {
                Resource.Error(e.message.toString())
            }
        }
    }

    override suspend fun fetchOtherCategories(
        token: String,
        packages: String,
        category: String,
        page: String,
        search: String,
        latest: String,
        language_id: String
    ): Resource<OtherModel> {

        return withContext(Dispatchers.IO) {

            try {
                val otherresponse = videoApi.OtherCategories(
                    token,
                    packages,
                    category,
                    page,
                    search,
                    latest,
                    language_id
                )
                if (otherresponse.isSuccessful && otherresponse.body() != null) {
                    Resource.Success(otherresponse.body()!!)
                } else {
                    Resource.Error(otherresponse.message())
                }

            } catch (e: Exception) {
                Resource.Error(e.message.toString())
            }
        }
    }


}