package com.azrinurvani.newsapijetpackcompose.data.source.network.service

import com.azrinurvani.newsapijetpackcompose.BuildConfig
import com.azrinurvani.newsapijetpackcompose.data.source.network.remote_model.ResponseEverything
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("everything")
    suspend fun getAllEverything(
        @Query("q") query : String,
        @Query("apiKey") apiKey : String = BuildConfig.API_KEY
    ) : ResponseEverything
}