package pat.project.challengehack.screens.main.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import basic.domain.main.interactors.MainIntercator
import basic.domain.main.models.GenreEntity
import basic.domain.main.models.RelizeEntity
import basic.domain.main.models.TransEntity
import common.domain.entity.Entity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pat.project.challengehack.screens.main.mainScreen.models.MainNavDirections
import pat.project.challengehack.screens.main.mainScreen.models.MainUiState
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val mainIntercator: MainIntercator,
) : ViewModel() {


    private val _mainUIState = MutableStateFlow(MainUiState())
    val mainUiState = _mainUIState.asStateFlow()

    private val _mainNavDirections = MutableStateFlow<MainNavDirections>(MainNavDirections.Default)
    val mainNavDirections = _mainNavDirections.asStateFlow()

    val translationList = listOf<TransEntity>(
        TransEntity(1, "", ""),
        TransEntity(1, "", ""),
        TransEntity(1, "", ""),
        TransEntity(1, "", ""),
    )



    fun getReleaseList() {
        viewModelScope.launch {
            when (val response = mainIntercator.getLastReleases()) {
                is Entity.Success -> {
                    _mainUIState.update { mainUiState ->
                        mainUiState.copy(
                            relizeList = response.data
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

    fun getGenreList() {
        viewModelScope.launch {
            when (val response = mainIntercator.getGenres()) {
                is Entity.Success -> {
                    _mainUIState.update { mainUiState ->
                        mainUiState.copy(
                            genreList = response.data
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


//    fun navigateToFriendList() {
//        _mainNavDirections.update {
//            MainNavDirections.FriendList
//        }
//    }
//
//    fun navigateToDirectChat(chatId: Int) {
//        _mainNavDirections.update {
//            MainNavDirections.Chat(chatId)
//        }
//    }
//
//    fun navigateToServerChat(serverId: Int) {
//        _mainNavDirections.update {
//            MainNavDirections.Server(serverId)
//        }
//    }
//
//    fun clearNavDirections() {
//        _mainNavDirections.update {
//            MainNavDirections.Default
//        }
//    }

}