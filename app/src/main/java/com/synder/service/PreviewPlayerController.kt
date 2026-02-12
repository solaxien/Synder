package com.synder.service

import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreviewPlayerController @Inject constructor(
    private val player: ExoPlayer
) {
    private var currentSongId: String? = null

    fun playPreview(songId: String, previewUrl: String) {
        if (currentSongId == songId) return
        currentSongId = songId
        player.setMediaItem(MediaItem.fromUri(previewUrl))
        player.prepare()
        player.playWhenReady = true
    }

    fun stop() {
        player.stop()
        currentSongId = null
    }
}
