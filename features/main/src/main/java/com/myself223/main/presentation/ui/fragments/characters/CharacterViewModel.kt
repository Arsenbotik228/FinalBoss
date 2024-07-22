package com.myself223.main.presentation.ui.fragments.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.myself223.core.base.BaseViewModel
import com.myself223.domain.model.CharacterModel
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

    private val _searchQuery = MutableStateFlow<String?>(null)
    val searchQuery: StateFlow<String?> = _searchQuery.asStateFlow()

    private val _searchResults = MutableStateFlow<PagingData<CharacterUi>>(PagingData.empty())
    val searchResults: StateFlow<PagingData<CharacterUi>> = _searchResults.asStateFlow()

    fun searchCharacters(name: String) {
        _searchQuery.value = name
        viewModelScope.launch {
            searchUseCase.searchByName(name).collectLatest { characters ->
                _searchResults.value = PagingData.from(characters.map { it.toUi() })
            }
        }
    }

    fun getCharacter(): Flow<PagingData<CharacterUi>> {
        return charactersUseCase().map { pagingData ->
            pagingData.map { it.toUi() }
        }.cachedIn(viewModelScope)
    }
}
