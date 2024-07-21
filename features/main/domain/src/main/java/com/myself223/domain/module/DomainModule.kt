package com.myself223.domain.module

import com.myself223.domain.usecase.CharactersUseCase
import com.myself223.domain.usecase.EpisodesUseCase
import com.myself223.domain.usecase.LocationUseCase
import org.koin.dsl.module

val useCaseModule = module {
     single{ CharactersUseCase(get()) }
     single{ EpisodesUseCase(get()) }
     single{ LocationUseCase(get()) }

}