package com.example.android4homework2.data.remote.apiservice

import com.example.android4homework2.data.model.anime.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val CHARACTERS_END_POINT = "edge/manga"

interface KitsuApiService {

    @GET(CHARACTERS_END_POINT)
    suspend fun getAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): AnimeResponse

//    @GET("anime")
//    fun getAnimeApi(
//        @Query("page[number]") pageNumber: Int,
//        @Query("page[size]") pageSize: Int
//    ): Call<AnimeResponse>
//
//    @GET("manga")
//    fun getManga(
//        @Query("page[number]") pageNumber: Int,
//        @Query("page[size]") pageSize: Int
//    ): Call<MangaResponse>
}