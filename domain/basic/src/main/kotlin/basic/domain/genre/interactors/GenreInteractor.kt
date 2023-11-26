package basic.domain.genre.interactors

import basic.domain.main.models.GenreEntity
import basic.domain.main.models.TrackEntity
import common.domain.entity.Entity

interface GenreInteractor {
    suspend fun getGenreMusicByName(genreName: String) : Entity<List<TrackEntity>>
    suspend fun getGenreInfo(genreName: String) : Entity<GenreEntity>
}