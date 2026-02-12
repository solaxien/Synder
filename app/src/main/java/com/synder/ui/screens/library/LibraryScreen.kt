package com.synder.ui.screens.library

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun LibraryScreen(innerPadding: PaddingValues, viewModel: LibraryViewModel = hiltViewModel()) {
    val songs = viewModel.songs.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        items(songs.value, key = { it.id }) { song ->
            Card(modifier = Modifier.padding(bottom = 12.dp)) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(song.title)
                    Text(song.artist)
                }
            }
        }
    }
}
