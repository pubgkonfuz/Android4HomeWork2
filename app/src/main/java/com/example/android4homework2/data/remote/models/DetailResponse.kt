package com.example.android4homework2.data.remote.models

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("data")
    val data: DataItem
)
