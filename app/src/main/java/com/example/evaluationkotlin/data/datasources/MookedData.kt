package com.example.evaluationkotlin.data.datasources

import com.example.evaluationkotlin.domain.models.Name
import com.example.evaluationkotlin.domain.models.Pokemon
import com.example.evaluationkotlin.domain.models.Sprites
import com.example.evaluationkotlin.domain.models.Stats
import com.example.evaluationkotlin.domain.models.Type


/* recupere une liste mookée de pokemon*/

fun getAllPokemon(): List<Pokemon> {
    return listOf(
        Pokemon(
            pokedex_id = 1,
            generation = 1,
            category = "Pokémon Normal",
            name = Name(
                fr = "Bulbizarre",
                en = "Bulbasaur",
                jp = "フシギダネ"
            ),
            sprites = Sprites(
                regular = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/1/regular.png",
                shiny = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/1/shiny.png",
                gmax = null
            )
            ,
            types = listOf (
                Type(
                    name = "Plante",
                    image = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/types/plante.png")

            ),
            stats = Stats(
                hp = 45,
                atk = 49,
                def = 49,
                spe_atk = 65,
                spe_def = 65
            )),

        Pokemon(
            pokedex_id = 2,
            generation = 1,
            category = "Pokémon Graine",
            name = Name(
                fr = "Herbizarre",
                en = "Ivysaur",
                jp = "フシギソウ"
            ),
            sprites = Sprites(
                regular = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/2/regular.png",
                shiny = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/2/shiny.png",
                gmax = null
            ),
            types = listOf(
                Type(
                    name = "Plante",
                    image = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/types/plante.png")

            ),
            stats = Stats(
                hp = 60,
                atk = 62,
                def = 63,
                spe_atk = 80,
                spe_def = 80
            ))  )

}
// Récupere un pokemon mooké
fun getPoke() : Pokemon {
     return Pokemon(
        pokedex_id = 1,
        generation = 1,
        category = "Pokémon Normal",
        name = Name(
            fr = "Bulbizarre",
            en = "Bulbasaur",
            jp = "フシギダネ"
        ),
        sprites = Sprites(
            regular = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/1/regular.png",
            shiny = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/1/shiny.png",
            gmax = null
        )
        ,
        types = listOf (
            Type(
                name = "Plante",
                image = "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/types/plante.png")

        ),
        stats = Stats(
            hp = 45,
            atk = 49,
            def = 49,
            spe_atk = 65,
            spe_def = 65
        ))

}