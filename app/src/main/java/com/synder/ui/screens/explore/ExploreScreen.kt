package com.synder.ui.screens.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.synder.domain.model.Song
import com.synder.ui.components.SwipeableCardStack

@Composable
fun ExploreScreen(innerPadding: PaddingValues, viewModel: ExploreViewModel = hiltViewModel()) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        SwipeableCardStack(
            items = state.value.songs,
            onSwipeLeft = viewModel::swipeLeft,
            onSwipeRight = viewModel::swipeRight
        ) { song, _ ->
            ExploreSongCard(song)
        }
    }
}

@Composable
private fun ExploreSongCard(song: Song) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = song.albumArtUrl,
            contentDescription = song.title,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(28.dp))
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        0f to Color.Transparent,
                        1f to Color.Black.copy(alpha = 0.75f)
                    )
                )
                .padding(20.dp)
        ) {
            Text(song.title, color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(song.artist, color = Color.White.copy(alpha = 0.85f), fontSize = 16.sp)
        }
    }
}
