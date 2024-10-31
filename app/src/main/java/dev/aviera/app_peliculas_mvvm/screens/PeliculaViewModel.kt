package dev.aviera.app_peliculas_mvvm.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.aviera.app_peliculas_mvvm.model.Pelicula
import dev.aviera.app_peliculas_mvvm.repository.PeliculaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeliculaViewModel @Inject constructor(
    private val repo : PeliculaRepository
): ViewModel(){
    private val _state = MutableStateFlow(emptyList<Pelicula>())
    val state : StateFlow<List<Pelicula>>
        get() = _state
    init {
        viewModelScope.launch {
            try {
                // Llama al repositorio para obtener las películas
                _state.value = repo.getPeliculas().results
            } catch (e: Exception) {
                Log.e("PeliculaViewModel", "Error al obtener películas: ${e.message}")
                // Manejar el error adecuadamente, tal vez actualizar el estado para mostrar un mensaje de error
            }
        }
    }
}