package com.myself223.data.remote.sourse

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.myself223.data.remote.apiservice.ApiService
import com.myself223.domain.model.CharacterModel

class SearchCharacterByNameSource(
    private val apiService: ApiService,
    private val name: String
) : PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val page = params.key ?: 1
        return try {
            val response = apiService.getCharactersByName(name,page)
            val characters = response.results.map { it.toDomain() }
            LoadResult.Page(
                data = characters,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.info.next == null) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }
}
