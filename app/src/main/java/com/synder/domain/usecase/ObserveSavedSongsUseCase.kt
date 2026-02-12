package com.synder.domain.usecase

import com.synder.domain.repository.MusicRepository
import javax.inject.Inject

class ObserveSavedSongsUseCase @Inject constructor(
    private val repository: MusicRepository
) {
    operator fun invoke() = repository.observeSavedSongs()
}
