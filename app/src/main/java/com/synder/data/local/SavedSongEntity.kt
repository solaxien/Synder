package com.synder.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_songs")
data class SavedSongEntity(
    @PrimaryKey val id: String,
    val title: String,
    val artist: String,
    val albumArtUrl: String,
    val previewUrl: String,
    val savedAt: Long = System.currentTimeMillis()
)
