package com.myself223.domain.usecase

import com.myself223.common.Either
import com.myself223.domain.model.CharacterModel
import com.myself223.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow

class CharactersUseCase(private val repository: CharacterRepository) {
    operator fun invoke() = repository.getAllCharacters()
}