package dev.aviera.app_peliculas_mvvm.api

import dev.aviera.app_peliculas_mvvm.model.ListaPeliculas
import dev.aviera.app_peliculas_mvvm.model.Pelicula
import dev.aviera.app_peliculas_mvvm.utils.Constants.API_KEY
import dev.aviera.app_peliculas_mvvm.utils.Constants.BASE_URL
import dev.aviera.app_peliculas_mvvm.utils.Constants.DEFAULT_PAGE
import dev.aviera.app_peliculas_mvvm.utils.Constants.LANGUAGE
import retrofit2.http.GET
import retrofit2.http.Query

interface IPeliculaApi {
    @GET("movie/now_playing")
    suspend fun getPeliculas(
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String = LANGUAGE,
        @Query("page") page: Int = DEFAULT_PAGE
    ) : ListaPeliculas
}