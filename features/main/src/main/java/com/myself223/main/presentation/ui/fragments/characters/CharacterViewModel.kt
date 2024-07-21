package com.myself223.main.presentation.ui.fragments.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.myself223.core.base.BaseViewModel
import com.myself223.data.remote.dto.characters.CharacterDto
import com.myself223.domain.usecase.CharactersUseCase
import com.myself223.domain.usecase.SearchUseCase
import com.myself223.main.presentation.model.CharacterUi
import com.myself223.main.presentation.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val charactersUseCase: CharactersUseCase,
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {
    private val _searchString = MutableStateFlow("")
    val searchString: StateFlow<String> = _searchString

    private val _searchResult = MutableStateFlow<PagingData<CharacterUi>>(PagingData.empty())
    val searchResult: StateFlow<PagingData<CharacterUi>> = _searchResult

    fun searchByName(name: String): Flow<PagingData<CharacterUi>> {
        return searchUseCase.searchByName(name).map { pagingData ->
            pagingData.map { characterModel ->
                characterModel.toUi()
            }
        }.cachedIn(viewModelScope)
    }

    fun getCharacter(): Flow<PagingData<CharacterUi>> {
        return charactersUseCase().map { pagingData ->
            pagingData.map { characterModel ->
                characterModel.toUi()
            }
        }.cachedIn(viewModelScope)
    }

}