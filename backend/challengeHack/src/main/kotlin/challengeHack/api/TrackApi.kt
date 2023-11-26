package challengeHack.api

import challengeHack.dto.auth.response.AlbumDto
import challengeHack.dto.auth.response.GenreDto
import challengeHack.dto.auth.response.RelizeDtoResponse
import challengeHack.dto.auth.response.TrackDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TrackApi {

    @GET("api/v2/music/lastReleases")
    suspend fun getLatReLeases(
    ) : Response<List<RelizeDtoResponse>>

    @GET("api/v2/genres/all")
    suspend fun getGenres(
    ) : Response<List<GenreDto>>

    @GET("api/v2/music/genre")
    suspend fun getGenreMusicsByName(
        @Query("genre") genre: String
    ) : Response<List<TrackDto>>

    @GET("api/v2/genres")
    suspend fun getGenreInfo(
        @Query("genre") genre: String
    ) : Response<GenreDto>

    @GET("api/v2/music/album/{albumId}")
    suspend fun getAlbumMusicById(
        @Path("albumId") albumId: Int
    ) : Response<AlbumDto>

    @GET("api/v2/music/track/{trackId}")
    suspend fun getTrackDataFromId(
        @Path("trackId") trackId: Long
    ) : Response<TrackDto>
}