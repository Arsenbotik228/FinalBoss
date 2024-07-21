package com.myself223.data.remote.repository.character

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.data.remote.sourse.SearchByNameSource
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.repository.character.SearchByNameRepository
import kotlinx.coroutines.flow.Flow



class SearchByNameRepositoryImpl(private val api: ApiService) : SearchByNameRepository {
    override fun searchByName(name: String): Flow<PagingData<CharacterModel>> {
        return Pager(PagingConfig(pageSize = 20)) {
            SearchByNameSource(api, name)
        }.flow
    }


}