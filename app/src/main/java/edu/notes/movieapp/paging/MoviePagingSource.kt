package edu.notes.movieapp.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.notes.movieapp.datamodel.Results
import edu.notes.movieapp.network.MovieService
import edu.notes.movieapp.utilities.Constants
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class MoviePagingSource (private val movieService: MovieService) : PagingSource<Int, Results>() {
    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {

       return try {
           val page = params.key?:1
           val response = movieService.getAllPopularMovies(page,Constants.apiKey)
           val responsedata = response.body()!!.results
           val movieList = mutableListOf<Results>()
           movieList.addAll(responsedata)
           LoadResult.Page(
               data = movieList,
               prevKey = if(page == 1) null else page-1,
               nextKey = if(response.body()!!.results.isEmpty()) null else page+1

           )
       }catch (e : IOException){
           LoadResult.Error(e)
       }catch (e : HttpException){
           LoadResult.Error(e)
       }catch (e : Exception) {
           LoadResult.Error(e)
       }
    }
}