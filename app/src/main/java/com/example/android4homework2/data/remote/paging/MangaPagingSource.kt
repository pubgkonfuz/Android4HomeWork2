package com.example.android4homework2.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android4homework2.data.remote.apiservice.KitsuApiService
import com.example.android4homework2.data.remote.models.DataItem
import retrofit2.HttpException
import java.io.IOException

class MangaPagingSource(private val kitsuApiService: KitsuApiService) :
    PagingSource<Int, DataItem>() {

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        val pageSize = params.loadSize
        val offSet = params.key ?: 1
        return try {
            val response = kitsuApiService.getManga(limit = pageSize, offset = offSet)
            val nextPage = if (response.data.isNotEmpty()) offSet + 1 else null

            LoadResult.Page(
                data = response.data,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}