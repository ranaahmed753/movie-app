package edu.notes.movieapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.notes.movieapp.network.MovieService
import edu.notes.movieapp.paging.MoviePagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieService: MovieService) : ViewModel() {
//    fun getAllMovies() : Flow<PagingData<Result>> = Pager(
//        config = PagingConfig(6, enablePlaceholders = false)
//    ){
//        MoviePagingSource(movieService)
//    }.flow.cachedIn(viewModelScope)

    val listData = Pager(PagingConfig(pageSize = 5)){
        MoviePagingSource(movieService)
    }.flow.cachedIn(viewModelScope)
}