package com.example.cleancodetest.data.storage.sharedprefs

import android.content.Context
import com.example.cleancodetest.data.storage.UserStorage
import com.example.cleancodetest.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_name"
private const val KEY_FIRS_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"


class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRS_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRS_NAME, "") ?: ""
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, "Default lastName") ?: "Default lastName"

        return User(firstName = firstName, lastName = lastName)
    }
}