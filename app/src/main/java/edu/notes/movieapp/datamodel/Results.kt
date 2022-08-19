package edu.notes.movieapp.datamodel

data class Results(
    val id: String,
    val overview: String,
    val poster_path: String,
    val title: String,
    val backdrop_path : String,
    val release_date : String,
    val vote_average : String,
    val vote_count : String,
    val popularity : String
)