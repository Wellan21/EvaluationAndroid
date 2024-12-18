package com.example.evaluationkotlin.ui.screens.pokemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
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

@Composable
fun PokemonScreen(modifier: Modifier, id: Int, navController: NavHostController) {

    val viewModel: PokemonScreenViewModel = viewModel()
    val pokemon by viewModel.pokemon.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
    ) {
        pokemonCard(pokemon = pokemon, modifier = modifier)
    }

}

@Composable
fun pokemonCard(pokemon: Pokemon, modifier: Modifier) {
    ElevatedCard(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            , colors = cardColors( colorResource(R.color.card)),
        elevation = cardElevation(defaultElevation = 10.dp)
    ) {

        Row {

            AsyncImage(
                modifier = Modifier,
                model = pokemon.sprites.regular,
                contentDescription = null

            )
            AsyncImage(
                modifier = Modifier,
                model = pokemon.sprites.shiny,
                contentDescription = null
            )
        }
        Column(Modifier.padding(16.dp)) {
            Text(
                text = "${stringResource(R.string.NomFr)} ${pokemon.name.fr}",
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.NomEn)} " + pokemon.name.en,
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.NomJp)} " + pokemon.name.jp,
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.IdPokedex)} " + pokemon.pokedex_id.toString(),
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.Generation)} " + pokemon.generation.toString(),
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.Categorie)} " + pokemon.category,
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.HP)} " + pokemon.stats.hp.toString(),
                color = colorResource(R.color.Text)
            )
            Text(text = stringResource(R.string.Type), color = colorResource(R.color.Text))
            for (type in pokemon.types) {
                Row {
                    AsyncImage(
                        modifier = Modifier
                            .padding(vertical = 3.dp)
                            .size(20.dp),
                        model = type.image,
                        contentDescription = null

                    )
                    Text(text = " " + type.name, color = colorResource(R.color.Text))
                }
            }
            Text(
                text = "${stringResource(R.string.ATK)} " + pokemon.stats.atk.toString(),
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.DEF)} " + pokemon.stats.def.toString(),
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.SPE_ATK)} " + pokemon.stats.spe_atk.toString(),
                color = colorResource(R.color.Text)
            )
            Text(
                text = "${stringResource(R.string.SPE_DEF)} " + pokemon.stats.spe_def.toString(),
                color = colorResource(R.color.Text)
            )


        }
    }
}


@Preview
@Composable
private fun PokemonScreenPreview(modifier: Modifier = Modifier) {
    PokemonScreen(Modifier, navController = rememberNavController(), id = 1)
}