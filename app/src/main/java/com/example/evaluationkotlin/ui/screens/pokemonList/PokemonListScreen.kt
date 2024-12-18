package com.example.evaluationkotlin.ui.screens.pokemonList

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.evaluationkotlin.R
import com.example.evaluationkotlin.domain.models.Pokemon
import com.example.evaluationkotlin.nativeManagement.VibrationManager
import com.example.evaluationkotlin.nativeManagement.playBeeb
import com.example.evaluationkotlin.ui.screens.pokemon.PokemonListViewModel

@Composable
fun PokemonListScreen(navController: NavHostController) {
    val viewModel: PokemonListViewModel = viewModel()
    val pokemons by viewModel.pokemonList.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(vertical = 30.dp, horizontal = 10.dp)
                .fillMaxSize()
        ) {
            items(pokemons)
            { pokemon ->
                PokemonCard(pokemon = pokemon, navController = navController)
            }


        }
    }
}

@SuppressLint("NewApi")
@Composable
fun PokemonCard(pokemon: Pokemon, navController: NavHostController) {
    val mContext = LocalContext.current
    val vibrationManager = VibrationManager(mContext)
    ElevatedCard(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()

            .clickable {
                playBeeb(mContext)
                vibrationManager.vibratePhone()
                navController.navigate("pokemon/${pokemon.pokedex_id}")
            },
        colors = cardColors(colorResource(R.color.card)),
        elevation = cardElevation(defaultElevation = 10.dp),
    ) {
        Row(modifier = Modifier) {
            AsyncImage(
                modifier = Modifier.size(50.dp),
                model = pokemon.sprites.regular,
                contentDescription = null

            )

            Column {
                Text(
                    text = pokemon.name.fr + stringResource(R.string.hastag) + pokemon.pokedex_id.toString(),
                    color = colorResource(R.color.Text)
                )
                Text(text = stringResource(R.string.Type), color = colorResource(R.color.Text))
                for (type in pokemon.types) {
                    Row {
                        Modifier.padding(vertical = 3.dp)
                        AsyncImage(
                            modifier = Modifier
                                .padding(vertical = 3.dp)
                                .size(10.dp),
                            model = type.image,
                            contentDescription = null

                        )
                        Text(text = " " + type.name, color = colorResource(R.color.Text))
                    }
                }
            }
        }
    }
}


@Preview
@Composable
private fun PokemonListScreenPreview(modifier: Modifier = Modifier) {
    PokemonListScreen(navController = rememberNavController())
}