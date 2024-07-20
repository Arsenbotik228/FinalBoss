package com.myself223.domain.module

import com.myself223.domain.usecase.CharactersUseCase
import org.koin.dsl.factory
import org.koin.dsl.module

val useCaseModule = module {
     single{ CharactersUseCase(get()) }

}