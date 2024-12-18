package com.example.evaluationkotlin.data.repositories

import com.example.evaluationkotlin.data.datasources.getAllPokemon
import com.example.evaluationkotlin.data.datasources.getPoke
import com.example.evaluationkotlin.domain.models.Pokemon
 /* Repository permettant normalment de recuperer des données via l'api Tyradex. */
class PokemonRepository {

 //Recupere une pokemon via son Id.
     fun getPokemon(id: Int): Pokemon {
         return getPoke()
     }

     ///Recupere une liste de pokemon.
     fun getPokemonList(): List<Pokemon> {
        return getAllPokemon()
    }

}
