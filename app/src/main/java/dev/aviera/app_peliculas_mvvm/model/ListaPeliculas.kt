package dev.aviera.app_peliculas_mvvm.model

data class ListaPeliculas(
    val dates: Dates,
    val page: Int,
    val results: List<Pelicula>,
    val total_pages: Int,
    val total_results: Int
)