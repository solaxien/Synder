package com.synder.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SongDto(
    @SerialName("id") val id: String,
    @SerialName("title") val title: String,
    @SerialName("artist") val artist: String,
    @SerialName("albumArtUrl") val albumArtUrl: String,
    @SerialName("previewUrl") val previewUrl: String
)
