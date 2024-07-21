package com.myself223.domain.repository.character

import androidx.paging.PagingData
import com.myself223.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface SearchByNameRepository {
    fun searchByName(name:String): Flow<PagingData<CharacterModel>>
}