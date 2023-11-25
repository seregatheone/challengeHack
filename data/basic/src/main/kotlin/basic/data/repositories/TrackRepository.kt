package basic.data.repositories

import basic.domain.main.models.AlbumEntity
import basic.domain.main.models.GenreEntity
import basic.domain.main.models.RelizeEntity
import basic.domain.main.models.TrackEntity
import common.domain.entity.Entity

interface TrackRepository {
    suspend fun getLastReleases() : Entity<List<RelizeEntity>>
    suspend fun getGenres() : Entity<List<GenreEntity>>
    suspend fun getAlbumMusicById(albumId: Int) : Entity<AlbumEntity>
    suspend fun getGenreInfo(genreName: String) : Entity<GenreEntity>

    suspend fun getGenreMusicByName(genreName: String): Entity<List<TrackEntity>>
}