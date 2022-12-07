package com.example.cleancodetest.domain.usecase

import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        val result = userRepository.saveName(saveParam = param)
        return result
    }
}