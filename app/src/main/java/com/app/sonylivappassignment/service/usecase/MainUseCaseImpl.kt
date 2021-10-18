package com.app.sonylivappassignment.service.usecase

import com.app.sonylivappassignment.service.model.Languages

interface MainUseCaseImpl {

    fun onSuccess(response: Languages?)

    fun onError()
}