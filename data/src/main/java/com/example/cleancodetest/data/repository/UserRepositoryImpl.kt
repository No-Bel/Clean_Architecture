package com.example.cleancodetest.data.repository

import com.example.cleancodetest.data.storage.models.User
import com.example.cleancodetest.data.storage.UserStorage
import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.models.UserName
import com.example.cleancodetest.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = User(firstName = saveParam.name, lastName = "" )
        val result = userStorage.save(user = user)
        return  result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firstName = user.firstName, lastName = user.lastName)
        return userName
    }
}