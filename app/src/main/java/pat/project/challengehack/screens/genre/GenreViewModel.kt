package pat.project.challengehack.screens.genre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basic.domain.genre.interactors.GenreInteractor
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.genre.models.GenreUiState
import pat.project.challengehack.screens.main.mainScreen.models.MainUiState
import javax.inject.Inject

@HiltViewModel
class GenreViewModel @Inject constructor(
    private val genreInteractor: GenreInteractor,
): ViewModel() {
    private val _genreUIState = MutableStateFlow(GenreUiState())
    val genreUiState = _genreUIState.asStateFlow()

    fun getGenreMusicByName(genreName: String) {
        viewModelScope.launch {
            when (val response = genreInteractor.getGenreMusicByName(genreName)) {
                is Entity.Success -> {
                    _genreUIState.update { genreUiState ->
                        genreUiState.copy(
                            soundList = response.data
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