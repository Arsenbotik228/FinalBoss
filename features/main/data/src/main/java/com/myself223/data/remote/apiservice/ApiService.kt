package com.myself223.data.remote.apiservice

import com.myself223.data.base.model.BaseMainResponse
import com.myself223.data.remote.dto.characters.CharacterDto
import com.myself223.data.remote.dto.episodes.EpisodesDto
import com.myself223.data.remote.dto.location.LocationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getCharacters(
        @Query("page") page: Int? = 1,
    ): BaseMainResponse<CharacterDto>
    @GET("character")
    suspend fun searchCharactersByName(
        @Query("name") name: String,
    ): BaseMainResponse<CharacterDto>

    @GET("episode")
    suspend fun getEpisodes(
        @Query("page") page: Int? = 1,
    ): BaseMainResponse<EpisodesDto>
    @GET("location")
    suspend fun getLocation(
        @Query("page") page: Int? = 1,
    ): BaseMainResponse<LocationDto>
}