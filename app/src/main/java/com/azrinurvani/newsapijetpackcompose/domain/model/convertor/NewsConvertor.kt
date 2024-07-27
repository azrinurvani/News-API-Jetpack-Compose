package com.azrinurvani.newsapijetpackcompose.domain.model.convertor

import com.azrinurvani.newsapijetpackcompose.data.source.network.remote_model.ResponseEverything
import com.azrinurvani.newsapijetpackcompose.domain.model.NewsUi
import com.azrinurvani.newsapijetpackcompose.domain.model.NewsUiState

fun newsResponseToNewsUi(response : ResponseEverything?) : NewsUiState =
    NewsUiState.Success(
        response?.articles?.map { article ->
            NewsUi(
                id = article?.source?.id.toString(),
                name = article?.source?.name.toString(),
                publishedAt = article?.publishedAt.toString(),
                title = article?.title.toString(),
                content = article?.content.toString(),
                author = article?.author.toString(),
                url = article?.url.toString(),
                urlToImage = article?.urlToImage.toString(),
                description = article?.description.toString()
            )
        }
    )

