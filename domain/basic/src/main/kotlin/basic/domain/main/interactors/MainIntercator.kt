package basic.domain.main.interactors

import basic.domain.main.models.AlbumEntity
import basic.domain.main.models.GenreEntity
import basic.domain.main.models.RelizeEntity
import common.domain.entity.Entity

interface MainIntercator {
    suspend fun getLastReleases() : Entity<List<RelizeEntity>>

    suspend fun getGenres() : Entity<List<GenreEntity>>
    suspend fun getAlbumMusicById(albumId: Int) : Entity<AlbumEntity>


}