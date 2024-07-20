package com.myself223.main.presentation.module

import com.myself223.main.presentation.ui.fragments.characters.CharacterViewModel
import org.koin.dsl.module


val uiModule = module {
    single { CharacterViewModel(get()) }
}