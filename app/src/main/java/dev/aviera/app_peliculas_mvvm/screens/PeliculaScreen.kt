package dev.aviera.app_peliculas_mvvm.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import coil.compose.AsyncImage
import dev.aviera.app_peliculas_mvvm.model.Pelicula
import dev.aviera.app_peliculas_mvvm.utils.Constants.API_KEY
import dev.aviera.app_peliculas_mvvm.utils.Constants.BASE_URL
import dev.aviera.app_peliculas_mvvm.utils.Constants.BASE_URL_IMAGE
import dev.aviera.app_peliculas_mvvm.utils.Constants.DEFAULT_PAGE
import dev.aviera.app_peliculas_mvvm.utils.Constants.LANGUAGE

@Composable
fun PeliculaScreen(
    viewModel: PeliculaViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    Log.d("Cantidad de items", "${state.size}")
    Log.d("Objeto", "${state}")

    LazyColumn() {
        items(state){pelicula ->
            PeliculaCard(pelicula)
        }
    }
}

@Composable
fun PeliculaCard(pelicula: Pelicula, modifier: Modifier=Modifier) {
    Log.d("PeliculaCardANDRES", "Pelicula: ${pelicula.id}")
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column {
            Row {
                Surface(
                    modifier.size(120.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                ) {
                    AsyncImage(
                        model = "${BASE_URL_IMAGE}${pelicula.poster_path}",
                        contentDescription = pelicula.title,
                        contentScale = ContentScale.FillBounds
                    )
                }
                Column(
                    modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                ) {
                    Text(text = "${pelicula.title}", style = MaterialTheme.typography.titleLarge)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "${pelicula.overview}")
                    }
                }
            }
        }
    }
}
