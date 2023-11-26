package impl.domain.interactors

import basic.data.repositories.AuthRepository
import basic.data.repositories.TrackRepository
import basic.domain.auth.interactors.AuthInteractor
import basic.domain.genre.interactors.GenreInteractor
import basic.domain.main.models.GenreEntity
import basic.domain.main.models.TrackEntity
import common.domain.entity.Entity

class GenreInteractorImpl(
    private val trackRepository: TrackRepository
) : GenreInteractor {
    override suspend fun getGenreMusicByName(genreName: String): Entity<List<TrackEntity>> {
        return trackRepository.getGenreMusicByName(genreName)
    }

    override suspend fun getGenreInfo(genreName: String): Entity<GenreEntity> {
        return trackRepository.getGenreInfo(genreName)
    }

}