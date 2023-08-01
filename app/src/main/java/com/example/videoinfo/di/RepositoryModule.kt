package com.example.videoinfo.di

import com.example.videoinfo.data.VideoApi
import com.example.videoinfo.data.respository.CategoriesImp
import com.example.videoinfo.data.respository.VideoCategoriesRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideVideoList(videoApi: VideoApi): VideoCategoriesRepo {

        return CategoriesImp(videoApi)
    }

}