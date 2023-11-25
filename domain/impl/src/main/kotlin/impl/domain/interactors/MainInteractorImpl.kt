package impl.domain.interactors

import basic.data.repositories.AuthRepository
import basic.data.repositories.TrackRepository
import basic.domain.auth.interactors.AuthInteractor
import basic.domain.main.interactors.MainIntercator
import basic.domain.main.models.AlbumEntity
import basic.domain.main.models.GenreEntity
import basic.domain.main.models.RelizeEntity
import common.domain.entity.Entity

class MainInteractorImpl(
    private val mainRepository: TrackRepository
) : MainIntercator {
    override suspend fun getLastReleases(): Entity<List<RelizeEntity>> {
        return mainRepository.getLastReleases()
    }

    override suspend fun getGenres(): Entity<List<GenreEntity>> {
        return mainRepository.getGenres()
    }

    override suspend fun getAlbumMusicById(albumId: Int): Entity<AlbumEntity> {
        return mainRepository.getAlbumMusicById(albumId)
    }
}