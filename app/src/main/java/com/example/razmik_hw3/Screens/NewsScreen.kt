package com.example.razmik_hw3.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.razmik_hw3.newsResources.News
import com.example.razmik_hw3.DataClasses.newsData
import com.example.razmik_hw3.R
import com.example.razmik_hw3.Results.NewsRefreshableColumn
import com.example.razmik_hw3.UI.SearchBar
import com.example.razmik_hw3.UI.FilterExpand
import com.example.razmik_hw3.Results.NewsRepo

@Composable
fun NewsScreen(navController: NavController,
               news: News,
               newsListResult: List<News>,
                onRefresh: () -> Unit,
                onSelectFilter:(String) -> Unit
) {
    Column {

        Text(text = news.title,
            style = TextStyle(fontSize = 24.sp),
            textAlign =  TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth())


        AsyncImage(

            model = news.imageUrl,
            error = painterResource(id = R.drawable.errorimg),
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            contentDescription = "news article image",
            placeholder = painterResource(id = R.drawable.loadingimg)
        )
        Text(text = news.author,
            style = TextStyle(fontSize = 12.sp),
            textAlign =  TextAlign.Center,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth())

        Divider(
            color = Color.Black,
            modifier = Modifier.padding(vertical = 20.dp)
        )

        NewsRefreshableColumn(
            data = newsListResult,
            news = news,
            onRefresh = onRefresh,
            navController = navController,
            onSelectFilter = onSelectFilter
        )
    }

}