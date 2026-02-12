package com.synder.ui.screens.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.synder.domain.model.Song
import com.synder.domain.usecase.ObserveSavedSongsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class LibraryViewModel @Inject constructor(
    observeSavedSongs: ObserveSavedSongsUseCase
) : ViewModel() {
    val songs: StateFlow<List<Song>> = observeSavedSongs()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}
