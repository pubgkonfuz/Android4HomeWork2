package com.example.android4homework2.data.model.anime

import com.google.gson.annotations.SerializedName

data class AnimeResponse(@SerializedName("data")
                         val data: List<DataItem>,
                         @SerializedName("links")
                         val links: Links
)