package com.example.android4homework2.data.model.anime

import com.google.gson.annotations.SerializedName

data class Links(@SerializedName("next")
                 val next: String = "",
                 @SerializedName("last")
                 val last: String = "",
                 @SerializedName("prev")
                 val prev: String = "",
                 @SerializedName("first")
                 val first: String = "")