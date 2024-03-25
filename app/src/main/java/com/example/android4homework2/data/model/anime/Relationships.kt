package com.example.android4homework2.data.model.anime

import com.google.gson.annotations.SerializedName

data class Relationships(@SerializedName("castings")
                         val castings: Castings,
                         @SerializedName("mappings")
                         val mappings: Mappings,
                         @SerializedName("animeStaff")
                         val animeStaff: AnimeStaff,
                         @SerializedName("reviews")
                         val reviews: Reviews,
                         @SerializedName("installments")
                         val installments: Installments,
                         @SerializedName("genres")
                         val genres: Genres,
                         @SerializedName("animeCharacters")
                         val animeCharacters: AnimeCharacters,
                         @SerializedName("mediaRelationships")
                         val mediaRelationships: MediaRelationships,
                         @SerializedName("animeProductions")
                         val animeProductions: AnimeProductions,
                         @SerializedName("categories")
                         val categories: Categories,
                         @SerializedName("streamingLinks")
                         val streamingLinks: StreamingLinks,
                         @SerializedName("episodes")
                         val episodes: Episodes
)