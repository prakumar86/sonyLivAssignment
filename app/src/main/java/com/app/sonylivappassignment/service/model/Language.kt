package com.app.sonylivappassignment.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Language(
    @SerializedName("key")
    @Expose
    var key: String,
    @SerializedName("value")
    @Expose
    var value: String
)