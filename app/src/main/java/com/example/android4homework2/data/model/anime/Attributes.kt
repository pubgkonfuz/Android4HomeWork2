package com.example.android4homework2.data.model.anime

import com.google.gson.annotations.SerializedName

data class Attributes(@SerializedName("endDate")
                      val endDate: String = "",
                      @SerializedName("episodeCount")
                      val episodeCount: Int = 0,
                      @SerializedName("ratingRank")
                      val ratingRank: Int = 0,
                      @SerializedName("posterImage")
                      val posterImage: PosterImage,
                      @SerializedName("createdAt")
                      val createdAt: String = "",
                      @SerializedName("subtype")
                      val subtype: String = "",
                      @SerializedName("youtubeVideoId")
                      val youtubeVideoId: String = "",
                      @SerializedName("averageRating")
                      val averageRating: String = "",
                      @SerializedName("coverImage")
                      val coverImage: CoverImage,
                      @SerializedName("ratingFrequencies")
                      val ratingFrequencies: RatingFrequencies,
                      @SerializedName("showType")
                      val showType: String = "",
                      @SerializedName("abbreviatedTitles")
                      val abbreviatedTitles: List<String>?,
                      @SerializedName("slug")
                      val slug: String = "",
                      @SerializedName("episodeLength")
                      val episodeLength: Int = 0,
                      @SerializedName("updatedAt")
                      val updatedAt: String = "",
                      @SerializedName("nsfw")
                      val nsfw: Boolean = false,
                      @SerializedName("synopsis")
                      val synopsis: String = "",
                      @SerializedName("titles")
                      val titles: Titles,
                      @SerializedName("ageRating")
                      val ageRating: String = "",
                      @SerializedName("favoritesCount")
                      val favoritesCount: Int = 0,
                      @SerializedName("coverImageTopOffset")
                      val coverImageTopOffset: Int = 0,
                      @SerializedName("canonicalTitle")
                      val canonicalTitle: String = "",
                      @SerializedName("tba")
                      val tba: String = "",
                      @SerializedName("userCount")
                      val userCount: Int = 0,
                      @SerializedName("popularityRank")
                      val popularityRank: Int = 0,
                      @SerializedName("ageRatingGuide")
                      val ageRatingGuide: String = "",
                      @SerializedName("startDate")
                      val startDate: String = "",
                      @SerializedName("status")
                      val status: String = "")