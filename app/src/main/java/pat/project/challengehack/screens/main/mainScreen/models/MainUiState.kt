package pat.project.challengehack.screens.main.mainScreen.models

import basic.domain.main.models.GenreEntity
import basic.domain.main.models.RelizeEntity
import basic.domain.main.models.TransEntity

data class MainUiState (
    val genreList: List<GenreEntity> = emptyList(),
    val relizeList: List<RelizeEntity> = emptyList(),
    val transList: List<TransEntity> = emptyList(),
)