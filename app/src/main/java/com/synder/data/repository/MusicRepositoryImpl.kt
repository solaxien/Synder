package com.synder.data.repository

import com.synder.data.local.SavedSongDao
import com.synder.data.mapper.toDomain
import com.synder.data.mapper.toEntity
import com.synder.data.remote.MockMusicDataSource
import com.synder.domain.model.Song
import com.synder.domain.repository.MusicRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class MusicRepositoryImpl @Inject constructor(
    private val dataSource: MockMusicDataSource,
    private val dao: SavedSongDao
) : MusicRepository {

    override suspend fun getExploreSongs(): List<Song> =
        dataSource.fetchSongs().map { it.toDomain() }

    override suspend fun saveSong(song: Song) {
        dao.insert(song.toEntity())
    }

    override fun observeSavedSongs() = dao.observeSavedSongs().map { list -> list.map { it.toDomain() } }
}
