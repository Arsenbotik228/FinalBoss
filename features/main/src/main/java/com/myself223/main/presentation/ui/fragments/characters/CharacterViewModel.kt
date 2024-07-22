package com.myself223.main.presentation.ui.fragments.characters

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.myself223.core.base.BaseViewModel
import com.myself223.domain.usecase.CharactersUseCase
import com.myself223.domain.usecase.SearchUseCase
import com.myself223.main.presentation.model.CharacterUi
import com.myself223.main.presentation.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val charactersUseCase: CharactersUseCase,
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {

    private val _characterResults = MutableStateFlow<PagingData<CharacterUi>>(PagingData.empty())
    val characterResults: StateFlow<PagingData<CharacterUi>> = _characterResults.asStateFlow()

    private val _searchResults = MutableStateFlow<PagingData<CharacterUi>>(PagingData.empty())
    val searchResults: StateFlow<PagingData<CharacterUi>> = _searchResults.asStateFlow()

    fun searchCharacters(name: String) {
        viewModelScope.launch {
            searchUseCase.searchByName(name)
                .map { pagingData -> pagingData.map { it.toUi() } }
                .cachedIn(viewModelScope) // Cache the Flow<PagingData> in ViewModel
                .collectLatest { pagingData ->
                    _searchResults.value = pagingData
                }
        }
    }

    fun getCharacter(): Flow<PagingData<CharacterUi>> {
        return charactersUseCase().map { pagingData ->
            pagingData.map { it.toUi() }
        }.cachedIn(viewModelScope) // Cache the Flow<PagingData> in ViewModel
    }
}
