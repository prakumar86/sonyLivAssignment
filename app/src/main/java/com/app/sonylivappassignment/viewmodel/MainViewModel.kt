package com.app.sonylivappassignment.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.sonylivappassignment.service.model.Language
import com.app.sonylivappassignment.service.model.Languages
import com.app.sonylivappassignment.service.usecase.MainUseCase
import com.app.sonylivappassignment.service.usecase.MainUseCaseImpl

class MainViewModel() : ViewModel(), MainUseCaseImpl {

    var languages = MutableLiveData<HashMap<String, List<Language>>>()


    fun getLanguageData() {
        val instance = MainUseCase.getInstance()
        instance?.setUseCase(this)
        instance?.getProjectList()
    }

    override fun onSuccess(response: Languages?) {
        languages.postValue(response?.languages)
    }

    override fun onError() {
        //error occurs while fetching data
    }
}