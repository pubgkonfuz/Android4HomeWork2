package com.example.android4homework2.data.model.anime

import com.google.gson.annotations.SerializedName

data class DataItem(@SerializedName("relationships")
                    val relationships: Relationships,
                    @SerializedName("links")
                    val links: Links,
                    @SerializedName("attributes")
                    val attributes: Attributes,
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("type")
                    val type: String = "")