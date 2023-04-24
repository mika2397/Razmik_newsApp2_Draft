package com.example.razmik_hw3.Results

import com.example.razmik_hw3.DataClasses.newsData
import com.example.razmik_hw3.newsResources.News
import retrofit2.create

class NewsRepo {
    suspend fun injectNews(category: String = "", q: String = ""): List<News> {
        return RetrofitHelper.getInstance().create(NewsApiService::class.java).getNews(category,q)
            .run {
                this.articles?.map {
                    News(name = it.title ?: "", description = it.description ?: "", author = it.author ?:"", title = it.title ?:"", imageUrl = it.urlToImage ?:"")
                } ?: listOf()
            }

    }
}