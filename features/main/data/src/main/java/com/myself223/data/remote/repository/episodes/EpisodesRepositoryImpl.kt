package com.myself223.data.remote.repository.episodes

import androidx.paging.PagingData
import com.myself223.data.base.repository.makePagingRequest
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.sourse.CharacterSource
import com.myself223.data.remote.sourse.EpisodesSource
import com.myself223.domain.model.EpisodesModel
import com.myself223.domain.repository.episodes.EpisodesRepository
import kotlinx.coroutines.flow.Flow



class EpisodesRepositoryImpl(private val api: ApiService) : EpisodesRepository {
    override fun getAllEpisodes(): Flow<PagingData<EpisodesModel>> =
        makePagingRequest(
        EpisodesSource(
            apiService = api
        )
    )

}