package com.example.evaluationkotlin.ui.screens.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluationkotlin.data.repositories.PokemonRepository
import com.example.evaluationkotlin.domain.models.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonListViewModel (): ViewModel() {
    private val pokemonRepository = PokemonRepository()

    private val _pokemonList = MutableStateFlow<List<Pokemon>>(listOf())
    val pokemonList : StateFlow<List<Pokemon>> = _pokemonList

    init {

        viewModelScope.launch(
            context = Dispatchers.IO
        ) {

            _pokemonList.value = getPokemonList()

        }

    }
}



suspend fun getPokemonList(): List<Pokemon> {

    val pokemonRepository = PokemonRepository()
    return pokemonRepository.getPokemonList()
}

