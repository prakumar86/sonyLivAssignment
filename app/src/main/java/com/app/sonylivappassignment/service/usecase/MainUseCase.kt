package com.app.sonylivappassignment.service.usecase

import com.app.sonylivappassignment.service.apiclient.ApiClient
import com.app.sonylivappassignment.service.apiclient.ApiInterface
import com.app.sonylivappassignment.service.model.Languages
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainUseCase {

    private lateinit var usecase: MainUseCaseImpl

    companion object {
        private var instance: MainUseCase? = null
        fun getInstance(): MainUseCase? {
            if (instance == null) {
                synchronized(MainUseCase::class.java) {
                    if (instance == null) {
                        instance = MainUseCase()
                    }
                }
            }
            return instance
        }

    }


    fun getProjectList() {
        val client = ApiClient.getClient()?.create(ApiInterface::class.java)
        val listResources = client?.doGetListResources()
        listResources?.enqueue(object : Callback<Languages?> {
            override fun onResponse(call: Call<Languages?>, response: Response<Languages?>) {
                if (response != null && usecase != null) {
                    usecase.onSuccess(response.body())
                }
            }

            override fun onFailure(call: Call<Languages?>, t: Throwable) {
                call.cancel()
                if (usecase != null) {
                    usecase.onError()
                }
            }

        })
    }

    fun setUseCase(useCase: MainUseCaseImpl) {
        this.usecase = useCase
    }
}