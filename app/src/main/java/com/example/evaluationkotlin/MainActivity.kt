package com.example.evaluationkotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evaluationkotlin.ui.screens.pokemon.PokemonScreen
import com.example.evaluationkotlin.ui.screens.pokemonList.PokemonListScreen
import com.example.evaluationkotlin.ui.theme.EvaluationKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Modifier.background(colorResource(R.color.background))
            EvaluationKotlinTheme {
               NavHost (
                   navController = navController,
                   startDestination = "pokemonList"

               )
               {
                   composable(
                       route = "pokemonList") {
                       PokemonListScreen(
                                navController = navController
                            )

                   }
                   composable(
                       route = "pokemon/{id}"
                   ) { backStackEntry ->
                       val pokemonId = backStackEntry.arguments?.getInt("id")

                       if (pokemonId == null) {
                           navController.popBackStack()
                           return@composable
                       }
                       PokemonScreen(
                               navController = navController,
                       modifier = Modifier,
                       id = pokemonId
                       )
                   }
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(

        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EvaluationKotlinTheme {
        Greeting("Android")
    }
}