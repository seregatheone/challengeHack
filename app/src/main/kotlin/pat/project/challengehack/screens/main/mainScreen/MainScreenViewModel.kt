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
                    _mainUIState.update { mainUiState ->
                        mainUiState.copy(
                            transList = listOf(
                                TransEntity(23424,"Классика","http://94.45.223.241:46876/storage/file_74150c4b-ac6d-45b0-bfe3-d2adc8306adc8b548cb5-395f-4e4a-9aab-61c72debdff0.png"),
                                TransEntity(17654534,"Шаман","http://94.45.223.241:46876/storage/file_3c78cf30-a101-4f0e-8d01-aa27fd5bc1ca82ba9b49-3918-4694-bcb4-dbe2dd4c0b77.png"),
                                TransEntity(2344,"Помоигите","http://94.45.223.241:46876/storage/file_59b7921c-28a6-45b5-b9c5-484b8aeaf8f4a87b53c7-b8d4-4585-a434-5f364ac530b8.png"),
                                TransEntity(5644,"Сон","http://94.45.223.241:46876/storage/file_74150c4b-ac6d-45b0-bfe3-d2adc8306adc8b548cb5-395f-4e4a-9aab-61c72debdff0.png"),
                            )
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