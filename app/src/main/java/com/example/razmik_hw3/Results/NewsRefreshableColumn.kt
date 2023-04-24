package com.example.razmik_hw3.Results

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.razmik_hw3.Screens.NewsScreen
import com.example.razmik_hw3.newsResources.News
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun NewsRefreshableColumn(
    data: List<News>,
    news: News,
    onRefresh: () -> Unit,
    navController: NavController,
    onSelectFilter:(String) -> Unit
) {
    val currentState = rememberSwipeRefreshState(isRefreshing = false)

    SwipeRefresh(
        state = currentState,
        onRefresh = {
            onRefresh()
            currentState.isRefreshing = false
        }) {
        NewsScreen(
            navController = navController,
            news = news,
            newsListResult = data,
            onRefresh = onRefresh,
            onSelectFilter = onSelectFilter
        )
    }
}