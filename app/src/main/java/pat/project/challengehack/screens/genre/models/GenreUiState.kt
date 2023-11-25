package pat.project.challengehack.screens.genre.models

import basic.domain.main.models.TrackEntity

data class GenreUiState(
    val soundList: List<TrackEntity> = emptyList()
)
