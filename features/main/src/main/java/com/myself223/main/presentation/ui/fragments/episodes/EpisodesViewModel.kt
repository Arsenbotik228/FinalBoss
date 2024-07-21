package com.myself223.main.presentation.ui.fragments.episodes

import com.myself223.core.base.BaseViewModel
import com.myself223.domain.usecase.EpisodesUseCase
import com.myself223.main.presentation.model.toUi

class EpisodesViewModel(
    private val episodesUseCase: EpisodesUseCase
) : BaseViewModel() {

    fun getEpisodes() = episodesUseCase().gatherPagingRequest {
        it.toUi()
    }
}