package com.myself223.domain.usecase

import com.myself223.domain.model.CharacterModel
import com.myself223.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class SearchUseCase(private val repository: CharacterRepository) {

    fun searchByName(name: String): Flow<List<CharacterModel>> {
        return repository.searchByName(name)
    }
}
