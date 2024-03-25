package com.example.android4homework2.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.android4homework2.data.remote.paging.AnimePagingSource
import com.example.android4homework2.data.remote.apiservice.KitsuApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class AnimeRepository(private val apiService: KitsuApiService) {

//    suspend fun getAnime(limit: Int, offset: Int, callback: (List<Data>, Boolean) -> Unit) {
//        apiService.getAnime(limit, offset).enqueue(object : Callback<MangaResponse> {
//            override fun onResponse(call: Call<MangaResponse>, response: Response<MangaResponse>) {
//                if (response.isSuccessful) {
//                    val mangaResponse = response.body()
//                    Log.e("data",response.body().toString())
//                    mangaResponse?.let {
//                        val animeList = it.data
//                        val isLastPage =
//                            animeList.isEmpty()
//                        callback(animeList, isLastPage)
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<MangaResponse>, t: Throwable) {
//                callback(emptyList(),false)
//            }
//        })
//    }

    fun getAnime() = Pager(
        PagingConfig(
            pageSize = 15,
            initialLoadSize = 15
        )
    ) {
        AnimePagingSource()
    }.flow.flowOn(Dispatchers.IO)
}