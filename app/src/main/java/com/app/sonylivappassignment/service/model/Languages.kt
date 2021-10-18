package com.app.sonylivappassignment.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Languages (
    @SerializedName("language")
    @Expose
    var languages: HashMap<String,List<Language>>
)