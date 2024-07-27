package com.azrinurvani.newsapijetpackcompose.domain.model


sealed class NewsUiState{
    data class Success(
        val newsUiList : List<NewsUi>?
    ) : NewsUiState()

    object Loading : NewsUiState()

    object Error : NewsUiState()
}

data class NewsUi (
    val id : String,
    val name : String,
    val publishedAt: String,
    val author: String,
    val urlToImage: String,
    val description: String,
    val title: String,
    val url: String,
    val content: String
)