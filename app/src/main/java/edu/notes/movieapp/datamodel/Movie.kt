package edu.notes.movieapp.datamodel

data class Movie(
    val page: Int,
    val results: List<Results>,
    val total_pages: Int,
    val total_results: Int
)