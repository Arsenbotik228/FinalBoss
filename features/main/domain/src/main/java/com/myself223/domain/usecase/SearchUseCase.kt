package com.myself223.domain.usecase

import androidx.paging.PagingData
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class SearchUseCase(private val repository: CharacterRepository) {

    fun searchByName(name: String): Flow<PagingData<CharacterModel>> {
        return repository.searchByName(name)
    }
}
