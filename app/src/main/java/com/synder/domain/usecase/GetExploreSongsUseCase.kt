package com.synder.domain.usecase

import com.synder.domain.repository.MusicRepository
import javax.inject.Inject

class GetExploreSongsUseCase @Inject constructor(
    private val repository: MusicRepository
) {
    suspend operator fun invoke() = repository.getExploreSongs()
}
