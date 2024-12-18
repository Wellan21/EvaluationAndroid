package com.example.evaluationkotlin.data.repositories

import com.example.evaluationkotlin.data.datasources.getAllPokemon
import com.example.evaluationkotlin.data.datasources.getPoke
import com.example.evaluationkotlin.domain.models.Pokemon
 /* Repository permettant normalment de recuperer des données via l'api Tyradex. */
class PokemonRepository {

 //
     fun getPokemon(id: Int): Pokemon {
         return getPoke()
     }
     fun getPokemonList(): List<Pokemon> {
        return getAllPokemon()
    }

}
