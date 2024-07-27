package com.azrinurvani.newsapijetpackcompose.ui.view.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.azrinurvani.newsapijetpackcompose.ui.view.Error
import com.azrinurvani.newsapijetpackcompose.ui.view.Loading
import com.azrinurvani.newsapijetpackcompose.domain.model.NewsUiState
import com.azrinurvani.newsapijetpackcompose.ui.home.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier,
    query : String?,
    homeViewModel: HomeViewModel,
){
    val viewState by homeViewModel.newsUiState.collectAsStateWithLifecycle()

    if (query!=null){
        LaunchedEffect(Unit) {
            homeViewModel.getEverythingNews(query)
        }
        when(val newsUiState = viewState){
            is NewsUiState.Success ->{
                NewsList(
                    modifier = modifier,
                    newsUiModelList = newsUiState.newsUiList
                )
            }
            is NewsUiState.Loading->{
                Loading()
            }
            is NewsUiState.Error ->{
                Error()
            }
        }
    }
}

private const val TAG = "HomeScreen"