package com.example.android4homework2.data.remote.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android4homework2.data.remote.apiservice.KitsuApiService
import com.example.android4homework2.data.remote.models.DataItem
import retrofit2.HttpException
import java.io.IOException

class AnimePagingSource(private val kitsuApiService: KitsuApiService) :
    PagingSource<Int, DataItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        val pageSize = params.loadSize
        val offSet = params.key ?: 1
        return try {
            val response = kitsuApiService.getAnime(limit = pageSize, offset = offSet)
            val nextPage =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
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

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}