package dev.aviera.app_peliculas_mvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.aviera.app_peliculas_mvvm.api.IPeliculaApi
import dev.aviera.app_peliculas_mvvm.utils.Constants.API_KEY
import dev.aviera.app_peliculas_mvvm.utils.Constants.BASE_URL
import dev.aviera.app_peliculas_mvvm.utils.Constants.LANGUAGE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): IPeliculaApi{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IPeliculaApi::class.java)
    }
}