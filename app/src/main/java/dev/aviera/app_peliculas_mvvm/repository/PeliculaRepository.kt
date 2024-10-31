package dev.aviera.app_peliculas_mvvm.repository

import dev.aviera.app_peliculas_mvvm.api.IPeliculaApi
import dev.aviera.app_peliculas_mvvm.model.ListaPeliculas
import dev.aviera.app_peliculas_mvvm.model.Pelicula
import javax.inject.Inject

class PeliculaRepository @Inject constructor(
    private val peliculaApi : IPeliculaApi
){
    suspend fun getPeliculas() : ListaPeliculas {
        return peliculaApi.getPeliculas()
    }
}