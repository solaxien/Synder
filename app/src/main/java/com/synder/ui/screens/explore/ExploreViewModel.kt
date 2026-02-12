package com.synder.ui.screens.explore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.synder.domain.model.Song
import com.synder.domain.usecase.GetExploreSongsUseCase
import com.synder.domain.usecase.SaveSongUseCase
import com.synder.service.PreviewPlayerController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val getExploreSongs: GetExploreSongsUseCase,
    private val saveSong: SaveSongUseCase,
    private val playerController: PreviewPlayerController
) : ViewModel() {

    private val _uiState = MutableStateFlow(ExploreUiState())
    val uiState: StateFlow<ExploreUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val songs = getExploreSongs()
            _uiState.value = ExploreUiState(songs = songs)
            playTopCardPreview()
        }
    }

    fun swipeRight(song: Song) {
        viewModelScope.launch {
            saveSong(song)
            moveNext(song)
        }
    }

    fun swipeLeft(song: Song) {
        moveNext(song)
    }

    private fun moveNext(song: Song) {
        _uiState.update { current ->
            current.copy(songs = current.songs.filterNot { it.id == song.id })
        }
        playTopCardPreview()
    }

    private fun playTopCardPreview() {
        val top = _uiState.value.songs.firstOrNull() ?: run {
            playerController.stop()
            return
        }
        playerController.playPreview(top.id, top.previewUrl)
    }

    override fun onCleared() {
        playerController.stop()
        super.onCleared()
    }
}

data class ExploreUiState(
    val songs: List<Song> = emptyList()
)
