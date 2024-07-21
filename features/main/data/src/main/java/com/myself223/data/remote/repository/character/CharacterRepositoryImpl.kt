package com.myself223.data.remote.repository.character

import androidx.paging.PagingData
import com.myself223.data.base.repository.makePagingRequest
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.sourse.CharacterSource
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow



class CharacterRepositoryImpl(private val api: ApiService) : CharacterRepository {
    override fun getAllCharacters(): Flow<PagingData<CharacterModel>> =
        makePagingRequest(
            CharacterSource(
                apiService = api
            )
        )


}