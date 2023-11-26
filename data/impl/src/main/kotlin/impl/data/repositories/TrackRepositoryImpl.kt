package impl.data.repositories

import backend.utils.models.ResponseStatus
import basic.data.repositories.TrackRepository
import basic.domain.main.models.AlbumEntity
import basic.domain.main.models.GenreEntity
import basic.domain.main.models.RelizeEntity
import basic.domain.main.models.TrackEntity
import challengeHack.api.TrackApi
import common.domain.entity.Entity
import impl.data.base.BaseRepository
import impl.data.mappers.asEntity

class TrackRepositoryImpl(
    private val trackApi: TrackApi,
) : TrackRepository, BaseRepository(AuthRepositoryImpl::class.toString()) {
    override suspend fun getLastReleases(): Entity<List<RelizeEntity>> {
        return when (val response = safeApiSuspendResult {
            trackApi.getLatReLeases()
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.map { it.asEntity() }
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }

            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }

            else -> {
                Entity.Error()
            }
        }


    }

    override suspend fun getGenres(): Entity<List<GenreEntity>> {
        return when (val response = safeApiSuspendResult {
            trackApi.getGenres()
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.map { it.asEntity() }
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }

            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }

            else -> {
                Entity.Error()
            }
        }
    }

    override suspend fun getAlbumMusicById(albumId: Int): Entity<AlbumEntity> {
        return when (val response = safeApiSuspendResult {
            trackApi.getAlbumMusicById(albumId)
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.asEntity()
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }

            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }

            else -> {
                Entity.Error()
            }
        }
    }

    override suspend fun getGenreInfo(genreName: String): Entity<GenreEntity> {
        return when (val response = safeApiSuspendResult {
            trackApi.getGenreInfo(genreName)
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.asEntity()
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }

            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }

            else -> {
                Entity.Error()
            }
        }
    }

    override suspend fun getGenreMusicByName(genreName: String): Entity<List<TrackEntity>> {
        return when (val response = safeApiSuspendResult {
            trackApi.getGenreMusicsByName(genreName)
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.map { it.asEntity() }
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }

            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }

            else -> {
                Entity.Error()
            }
        }
    }

    override suspend fun getTrackById(trackId: Long): Entity<TrackEntity> {
        return when (val response = safeApiSuspendResult {
            trackApi.getTrackDataFromId(trackId)
        }) {
            is ResponseStatus.Success -> {
                response.data?.let {
                    map {
                        it.asEntity()
                    }
                } ?: kotlin.run {
                    Entity.Error(
                        "Ошибка парсинга информации пользователя"
                    )
                }

            }

            is ResponseStatus.Error -> {
                Entity.Error(
                    response.exception.message ?: ""
                )
            }

            else -> {
                Entity.Error()
            }
        }
    }

}