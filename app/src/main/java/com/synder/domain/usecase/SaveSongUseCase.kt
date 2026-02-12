package com.synder.domain.usecase

import com.synder.domain.model.Song
import com.synder.domain.repository.MusicRepository
import javax.inject.Inject

class SaveSongUseCase @Inject constructor(
    private val repository: MusicRepository
) {
    suspend operator fun invoke(song: Song) = repository.saveSong(song)
}
