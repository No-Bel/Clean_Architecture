package com.example.cleancodetest.di

import com.example.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.cleancodetest.domain.usecase.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }
}