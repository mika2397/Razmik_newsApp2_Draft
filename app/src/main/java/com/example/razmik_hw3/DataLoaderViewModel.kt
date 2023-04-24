package com.example.razmik_hw3

import androidx.lifecycle.*

import com.example.razmik_hw3.DataClasses.newsData
import com.example.razmik_hw3.Results.NewsRepo
import com.example.razmik_hw3.newsResources.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DataLoaderViewModel : ViewModel(){

    private val refreshTrigger = MutableLiveData<Boolean>()
//    private val _isRefreshing= MutableStateFlow(false)
//    val isRefreshing: StateFlow<Boolean> get() = _isRefreshing.asStateFlow()

//    private val _item = MutableStateFlow<News?>(null)
//    val item: StateFlow<News?>
//        get() = _item.asStateFlow()

    private val newsListBase: MutableLiveData<List<News>> = MutableLiveData()
    val newsList: LiveData<List<News>> = newsListBase

    fun loadNews() {
            viewModelScope.launch {
                //val NewsList = mutableListOf<News>()
                val resultValues = NewsRepo().injectNews()
                newsListBase.postValue(resultValues)
                //async(Dispatchers.IO) {
                    //_item.emit(NewsRepo().injectNews().await())
                //    _item.emit()
                //}
//                fun refresh()
//                {
//                    newsListBase.value = resultValues
//                }
//                val newsResultMethod: LiveData<News> = newsList.switchMap {
//                    newsList
//                }


        }
    }

    fun loadFilteredNews(category:String,searchData:String) {
        viewModelScope.launch {
            val resultValues = NewsRepo().injectNews(category,searchData)
            newsListBase.postValue(resultValues)
        }
    }

}