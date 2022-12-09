package com.example.cleancodetest.presentetion

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleancodetest.domain.models.SaveUserNameParam
import com.example.cleancodetest.domain.usecase.GetUserNameUseCase
import com.example.cleancodetest.domain.usecase.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    var resultLive = MutableLiveData<String>()

    fun save(text: String) {
        val param = SaveUserNameParam(name = text)
        val result = saveUserNameUseCase.execute(param = param)
        resultLive.value = "Save result = $result"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
        resultLive.value = "${userName.firstName}"
    }

    init {
        Log.e("AAA", "VM Created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM Created")
        super.onCleared()
    }
}