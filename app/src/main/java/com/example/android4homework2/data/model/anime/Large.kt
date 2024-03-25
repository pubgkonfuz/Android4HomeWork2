package com.example.android4homework2.data.model.anime

import com.google.gson.annotations.SerializedName

data class Large(@SerializedName("width")
                 val width: String? = null,
                 @SerializedName("height")
                 val height: String? = null)