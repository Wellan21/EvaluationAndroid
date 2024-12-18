package com.example.evaluationkotlin.ui.screens.pokemonList

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

///Ecran permettant de lister les pokemons
@Composable
fun PokemonListScreen(navController: NavHostController) {
// Appel du viewModel et récuperation des pokemons.
    val viewModel: PokemonListViewModel = viewModel()
    val pokemons by viewModel.pokemonList.collectAsState()

    //Box permettant de mettre un background
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        //Colonne permettant d'afficher les differents pokemons
        LazyColumn(
            modifier = Modifier
                .padding(vertical = 30.dp, horizontal = 10.dp)
                .fillMaxSize()
        ) {
            //Liste les pokemons de la liste un a un et appelle la composable PokemonCard
            items(pokemons)
            { pokemon ->
                PokemonCard(pokemon = pokemon, navController = navController)
            }


        }
    }
}

///Composable représentant un pokemon
@Composable
fun PokemonCard(pokemon: Pokemon, navController: NavHostController) {
    val mContext = LocalContext.current
    val vibrationManager = VibrationManager(mContext)
    ElevatedCard(
        Modifier
            .padding(8.dp)
            .fillMaxWidth()
            // Au clic de l'utilisateur sur la carte on joue un son et  on fait vibrer le telephone et on navigue
            .clickable {
                playBeeb(mContext)
                vibrationManager.vibratePhone()
                navController.navigate("pokemon/${pokemon.pokedex_id}")
            },
        colors = cardColors(colorResource(R.color.card)),
        elevation = cardElevation(defaultElevation = 10.dp),
    ) {
        //Ligne contenant l'image du pokemon et les informations
        Row(modifier = Modifier) {
            AsyncImage(
                modifier = Modifier.size(50.dp),
                model = pokemon.sprites.regular,
                contentDescription = null

            )
            //Colonne contenant les informations
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