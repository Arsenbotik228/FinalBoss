package com.myself223.domain.module

import com.myself223.domain.usecase.CharactersUseCase
import com.myself223.domain.usecase.EpisodesUseCase
import com.myself223.domain.usecase.FiltredCharactersUseCase
import com.myself223.domain.usecase.LocationUseCase
import com.myself223.domain.usecase.SearchCharacterUseCase
import org.koin.dsl.module

val useCaseModule = module {
     factory{ SearchCharacterUseCase(get()) }
     factory{ FiltredCharactersUseCase(get()) }
     factory{ CharactersUseCase(get()) }
     factory{ EpisodesUseCase(get()) }
     factory{ LocationUseCase(get()) }

}