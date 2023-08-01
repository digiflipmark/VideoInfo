package com.example.videoinfo.data

import com.example.videoinfo.data.model.OtherModel
import com.example.videoinfo.data.model.VideoPojo
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface VideoApi {

    @FormUrlEncoded
    @POST("api/getVideoCategories")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun videoCategories(
        @Field(value = "token", encoded = true) token: String,
        @Field("package") packages: String,
        @Field("type") type: String,
        @Field("language_id") language_id: String
    ): Response<VideoPojo.VideoCategoriesPojo>


    @FormUrlEncoded
    @POST("api/getVideos")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun TrendCategories(
        @Field(value = "token", encoded = true) token: String,
        @Field("package") packages: String,
        @Field("category") category: String,
        @Field("page") page: String,
        @Field("search") search: String,
        @Field("latest") latest: String,
        @Field("language_id") language_id: String
    ): Response<VideoPojo.TrendModel>


    @FormUrlEncoded
    @POST("api/getVideos")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun OtherCategories(
        @Field(value = "token", encoded = true) token: String,
        @Field("package") packages: String,
        @Field("category") category: String,
        @Field("page") page: String,
        @Field("search") search: String,
        @Field("type") type: String,
        @Field("language_id") language_id: String
    ): Response<OtherModel>
}