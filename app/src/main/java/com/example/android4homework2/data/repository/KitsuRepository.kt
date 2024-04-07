package com.example.android4homework2.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.android4homework2.data.remote.apiservice.DetailApiService
import com.example.android4homework2.data.remote.apiservice.KitsuApiService
import com.example.android4homework2.data.remote.models.DataItem
import com.example.android4homework2.data.remote.paging.AnimePagingSource
import com.example.android4homework2.data.remote.paging.MangaPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KitsuRepository @Inject constructor(
    private val kitsuApiService: KitsuApiService,
    private val detailKitsuApi: DetailApiService
) {
    fun fetchAnime(): LiveData<PagingData<DataItem>> {

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimePagingSource(kitsuApiService) }
        ).liveData
    }

    fun fetchManga(): LiveData<PagingData<DataItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),

            pagingSourceFactory = { MangaPagingSource(kitsuApiService) }
        ).liveData
    }

    fun getMangaById(id: Int) = flow {
        emit(detailKitsuApi.getMangaById(id).data)
    }.flowOn(Dispatchers.IO)

    fun getAnimeById(id: Int) = flow {
        emit(detailKitsuApi.getAnimeById(id).data)
    }.flowOn(Dispatchers.IO)

}