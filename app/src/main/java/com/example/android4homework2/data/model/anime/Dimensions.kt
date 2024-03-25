package com.example.android4homework2.data.model.anime

import com.google.gson.annotations.SerializedName

data class Dimensions(@SerializedName("small")
                      val small: Small,
                      @SerializedName("large")
                      val large: Large,
                      @SerializedName("tiny")
                      val tiny: Tiny
)