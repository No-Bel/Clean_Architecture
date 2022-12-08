package com.example.cleancodetest.di

import com.example.cleancodetest.data.repository.UserRepositoryImpl
import com.example.cleancodetest.data.storage.UserStorage
import com.example.cleancodetest.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleancodetest.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}