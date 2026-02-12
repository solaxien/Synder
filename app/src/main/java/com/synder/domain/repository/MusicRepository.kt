package com.synder.domain.repository

import com.synder.domain.model.Song
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    suspend fun getExploreSongs(): List<Song>
    suspend fun saveSong(song: Song)
    fun observeSavedSongs(): Flow<List<Song>>
}
