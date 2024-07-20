package com.myself223.data.module

import com.myself223.data.remote.repository.character.CharacterRepositoryImpl
import com.myself223.domain.repository.character.CharacterRepository
import org.koin.dsl.module

val repoModule = module {
    single<CharacterRepository>{ CharacterRepositoryImpl(get()) }
}