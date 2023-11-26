package pat.project.challengehack.screens.album

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basic.domain.main.interactors.MainIntercator
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.album.models.AlbumUiState
import pat.project.challengehack.screens.genre.models.GenreUiState
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val mainIntercator: MainIntercator
):ViewModel() {
    private val _albumUIState = MutableStateFlow(AlbumUiState())
    val albumUiState = _albumUIState.asStateFlow()

    fun getAlbumMusicById(albumId: Int) {
        viewModelScope.launch {
            when (val response = mainIntercator.getAlbumMusicById(albumId)) {
                is Entity.Success -> {
                    _albumUIState.update { albumUiState ->
                        albumUiState.copy(
                            albumInfo = response.data
                        )
                    }
                }

                is Entity.Error -> {

                }

                else -> {

                }
            }
        }
    }
}