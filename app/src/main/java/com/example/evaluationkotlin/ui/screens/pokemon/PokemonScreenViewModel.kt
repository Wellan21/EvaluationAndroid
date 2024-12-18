package com.example.evaluationkotlin.ui.screens.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.evaluationkotlin.data.repositories.PokemonRepository
import com.example.evaluationkotlin.domain.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokemonScreenViewModel (): ViewModel()
{
    private val pokemonRepository = PokemonRepository()

    private val _pokemon  = MutableStateFlow<Pokemon>(createNullPoke())
   val pokemon : StateFlow<Pokemon> = _pokemon

    init {

        viewModelScope.launch(
            context = Dispatchers.IO
        ) {

            _pokemon.value = getPokemon(1)

        }

    }
}



suspend fun getPokemon(id: Int): Pokemon {

    val pokemonRepository = PokemonRepository()
    return pokemonRepository.getPokemon(id)
    }


fun createNullPoke(): Pokemon {
   return Pokemon(
        pokedex_id = 0,
        generation = 0,
        category = "",
        name = Name(
            fr = "",
            en = "",
            jp = ""
        ),
        sprites = Sprites(
            regular = "",
            shiny = "",
            gmax = ""
        ),
        types = listOf(),

        stats = Stats(
            hp = 0,
            atk = 0,
            def = 0,
            spe_atk = 0,
            spe_def = 0,
        )

    )
}