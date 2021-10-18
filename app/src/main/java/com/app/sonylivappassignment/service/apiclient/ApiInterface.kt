package com.app.sonylivappassignment.service.apiclient

import com.app.sonylivappassignment.service.model.Languages
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface ApiInterface {
    @Headers("Content-Type: application/json")
    @GET("v3/c45a571c-11d1-4d05-b711-71c8aa167037")
    fun doGetListResources(): Call<Languages?>?
}