package com.myself223.main.presentation.ui.fragments.locations

import com.myself223.core.base.BaseViewModel
import com.myself223.domain.usecase.LocationUseCase
import com.myself223.main.presentation.model.toUi

class LocationViewModel(
    private val locationUseCase: LocationUseCase
) : BaseViewModel() {

    fun getLocation() = locationUseCase().gatherPagingRequest {
        it.toUi()
    }
}