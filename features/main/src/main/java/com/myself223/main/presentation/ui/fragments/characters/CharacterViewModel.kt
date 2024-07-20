package com.myself223.main.presentation.ui.fragments.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.myself223.core.base.BaseViewModel
import com.myself223.data.remote.dto.characters.CharacterDto
import com.myself223.domain.usecase.CharactersUseCase
import com.myself223.main.presentation.model.CharacterUi
import com.myself223.main.presentation.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharacterViewModel(
    private val charactersUseCase: CharactersUseCase
) : BaseViewModel() {

    fun getCharacter() = charactersUseCase().gatherPagingRequest {
        it.toUi()
    }
}