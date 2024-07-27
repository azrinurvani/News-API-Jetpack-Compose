package com.azrinurvani.newsapijetpackcompose.data.repository

import com.azrinurvani.newsapijetpackcompose.data.source.network.service.ApiService
import com.azrinurvani.newsapijetpackcompose.domain.model.NewsUiState
import com.azrinurvani.newsapijetpackcompose.domain.model.convertor.newsResponseToNewsUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class NewsRepository @Inject constructor(
    private val newsService : ApiService
) {
    fun getAllEverything(query: String) : Flow<NewsUiState> = flow {
        try {
            emit(newsResponseToNewsUi(
                newsService.getAllEverything(query)
            ))
        }catch (t: Throwable){
            emit(NewsUiState.Error)
        }
    }

}