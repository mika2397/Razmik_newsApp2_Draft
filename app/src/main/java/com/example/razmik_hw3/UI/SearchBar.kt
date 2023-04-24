package com.example.razmik_hw3.UI

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import com.example.razmik_hw3.newsResources.News
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var searchVal by remember { mutableStateOf(TextFieldValue()) }

    Card(
        modifier = Modifier
            .padding(12.dp)
    )
    {
        Row {
            TextField(
                value = searchVal,
                onValueChange = {
                    searchVal = it
                    onSearch(it.text)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions
                    (onSearch = {
                    onSearch(searchVal.text)
                }
                ),
                placeholder = {
                    Text("Search the news")
                }
            )
        }
    }
}