package edu.notes.movieapp.network

import edu.notes.movieapp.datamodel.Movie
import edu.notes.movieapp.utilities.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular?page=_page&api_key=4077a5895397d5df8981126058bf5a4e")
    suspend fun getAllPopularMovies(
        @Query("page") _page : Int,
        @Query("api_key") apikey : String
    ) : Response<Movie>
}