package com.example.videoinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.videoinfo.data.Resource
import com.example.videoinfo.data.model.OtherModel
import com.example.videoinfo.data.model.VideoPojo
import com.example.videoinfo.data.respository.VideoCategoriesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViemodel @Inject constructor(private val videoCategoriesRepo: VideoCategoriesRepo) :
    ViewModel() {

    val videoList: MutableLiveData<Resource<MutableList<VideoPojo>>> = MutableLiveData()
    val otherList: MutableLiveData<Resource<OtherModel>> = MutableLiveData()

    fun fetchVideoCategories() {
        videoList.postValue(Resource.Loading())
        viewModelScope.launch {

            val topNftDeferred = async {
                videoCategoriesRepo.fetchVideoCategories(
                    "E%29%5Bi%3Bp9%26PMpx",
                    "com.way2status.allstatus",
                    "general",
                    ""
                )
            }   // without non blocking calls
            val trendingNftDeferred =
                async {
                    videoCategoriesRepo.fetchTrendCategories(
                        "E%29%5Bi%3Bp9%26PMpx",
                        "com.way2status.allstatus",
                        "43",
                        "1",
                        "",
                        "latest",
                        ""
                    )
                }   // without non blocking calls

            val topNft = topNftDeferred.await()
            val trendingNft = trendingNftDeferred.await()

            val nftList = mutableListOf<VideoPojo>()

            if (topNft is Resource.Success && trendingNft is Resource.Success) {
                nftList.add(VideoPojo.Titel("Featured", ""))
                nftList.addAll(topNft.data!!.data)
                nftList.addAll(trendingNft.data!!.data)
                videoList.postValue(Resource.Success(nftList))
            }
        }


    }

    fun fetchOtherCategories(id: Int) {

        otherList.postValue(Resource.Loading())
        viewModelScope.launch {

            val otherdata = videoCategoriesRepo.fetchOtherCategories(
                "E%29%5Bi%3Bp9%26PMpx",
                "com.way2status.allstatus",
                id.toString(),
                "1",
                "",
                "latest",
                ""
            )
            otherList.postValue(Resource.Success(otherdata.data!!))

        }
    }

}