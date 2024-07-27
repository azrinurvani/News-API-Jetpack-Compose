package com.azrinurvani.newsapijetpackcompose.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azrinurvani.newsapijetpackcompose.data.repository.NewsRepository
import com.azrinurvani.newsapijetpackcompose.di.IoDispatcher
import com.azrinurvani.newsapijetpackcompose.domain.model.NewsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val newsRepository: NewsRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : ViewModel(){

    private val _newsUiState : MutableStateFlow<NewsUiState> = MutableStateFlow(NewsUiState.Loading)

    val newsUiState: StateFlow<NewsUiState> get() = _newsUiState

    fun getEverythingNews(query : String){
        viewModelScope.launch(ioDispatcher) {
            _newsUiState.value = NewsUiState.Loading
            newsRepository.getAllEverything(query).collect{
                _newsUiState.value = it
            }
        }
    }
}