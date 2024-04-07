package com.example.android4homework2.data.remote.apiservice

import com.example.android4homework2.data.remote.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val ANIME_END_POINT = "anime"
private const val MANGA_END_POINT = "manga"

interface KitsuApiService {

    @GET(ANIME_END_POINT)
    suspend fun getAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): KitsuResponse

    @GET(MANGA_END_POINT)
    suspend fun getManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): KitsuResponse
}