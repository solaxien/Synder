package com.synder.data.mapper

import com.synder.data.local.SavedSongEntity
import com.synder.data.model.SongDto
import com.synder.domain.model.Song

fun SongDto.toDomain(): Song = Song(
    id = id,
    title = title,
    artist = artist,
    albumArtUrl = albumArtUrl,
    previewUrl = previewUrl
)

fun Song.toEntity(): SavedSongEntity = SavedSongEntity(
    id = id,
    title = title,
    artist = artist,
    albumArtUrl = albumArtUrl,
    previewUrl = previewUrl
)

fun SavedSongEntity.toDomain(): Song = Song(
    id = id,
    title = title,
    artist = artist,
    albumArtUrl = albumArtUrl,
    previewUrl = previewUrl
)
