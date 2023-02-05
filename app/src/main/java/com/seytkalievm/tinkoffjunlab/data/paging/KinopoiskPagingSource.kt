package com.seytkalievm.tinkoffjunlab.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.seytkalievm.tinkoffjunlab.data.remote.KinopoiskApi
import com.seytkalievm.tinkoffjunlab.data.model.FilmPreview
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1
private const val ENDING_PAGE_INDEX = 20

private const val TAG = "KinopoiskPagingSource"

class KinopoiskPagingSource(private val api: KinopoiskApi) : PagingSource<Int, FilmPreview>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FilmPreview> {
        val position = params.key?: STARTING_PAGE_INDEX

        return try {
            val previews = api.getTop100Films(position).films
            LoadResult.Page(
                data = previews,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (position == ENDING_PAGE_INDEX || previews.isEmpty()) null else position + 1
            )
        } catch (e: IOException){
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, FilmPreview>): Int? {
        return state.anchorPosition
    }
}