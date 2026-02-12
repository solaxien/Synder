package com.synder.data.remote

import android.content.Context
import com.synder.data.model.SongDto
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.serialization.json.Json

class MockMusicDataSource @Inject constructor(
    @ApplicationContext private val context: Context,
    private val json: Json
) {
    suspend fun fetchSongs(): List<SongDto> {
        val raw = context.assets.open("mock_songs.json").bufferedReader().use { it.readText() }
        return json.decodeFromString(raw)
    }
}
