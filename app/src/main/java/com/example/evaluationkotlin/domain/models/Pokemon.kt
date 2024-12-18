package com.example.evaluationkotlin.domain.models


/*{
    "pokedex_id": 246,
    "generation": 2,
    "category": "Pokémon Peaupierre",
    "name": {
    "fr": "Embrylex",
    "en": "Larvitar",
    "jp": "ヨーギラス"
},
    "sprites": {
    "regular": "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/246/regular.png",
    "shiny": "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/sprites/246/shiny.png",
    "gmax": null
},
    "types": [
    {
        "name": "Roche",
        "image": "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/types/roche.png"
    },
    {
        "name": "Sol",
        "image": "https://raw.githubusercontent.com/Yarkis01/TyraDex/images/types/sol.png"
    }
    ],
    "talents": [
    {
        "name": "Cran",
        "tc": false
    },
    {
        "name": "Voile Sable",
        "tc": true
    }
    ],
    "stats": {
    "hp": 50,
    "atk": 64,
    "def": 50,
    "spe_atk": 45,
    "spe_def": 50,
    "vit": 41
},

  "evolution": {
    "pre": null,
    "next": [
      {
        "pokedex_id": 247,
        "name": "Ymphect",
        "condition": "Niveau 30"
      },
      {
        "pokedex_id": 248,
        "name": "Tyranocif",
        "condition": "Niveau 55"
      },
    "resistances": [
    {
        "name": "Normal",
        "multiplier": 0.5
    },
    {
        "name": "Plante",
        "multiplier": 4
    },
    {
        "name": "Feu",
        "multiplier": 0.5
    },
    {
        "name": "Eau",
        "multiplier": 4
    },
    {
        "name": "Électrik",
        "multiplier": 0
    },
    {
        "name": "Glace",
        "multiplier": 2
    },
    {
        "name": "Combat",
        "multiplier": 2
    },
    {
        "name": "Poison",
        "multiplier": 0.25
    },
    {
        "name": "Sol",
        "multiplier": 2
    },
    {
        "name": "Vol",
        "multiplier": 0.5
    },
    {
        "name": "Psy",
        "multiplier": 1
    },
    {
        "name": "Insecte",
        "multiplier": 1
    },
    {
        "name": "Roche",
        "multiplier": 0.5
    },
    {
        "name": "Spectre",
        "multiplier": 1
    },
    {
        "name": "Dragon",
        "multiplier": 1
    },
    {
        "name": "Ténèbres",
        "multiplier": 1
    },
    {
        "name": "Acier",
        "multiplier": 2
    },
    {
        "name": "Fée",
        "multiplier": 1
    }
    ],
    "evolution": {
    "pre": null,
    "next": [
    {
        "pokedex_id": 247,
        "name": "Ymphect",
        "condition": "Niveau 30"
    },
    {
        "pokedex_id": 248,
        "name": "Tyranocif",
        "condition": "Niveau 55"
    }
    ],
    "mega": null
},
    "height": "0,6 m",
    "weight": "72,0 kg",
    "egg_groups": [
    "Monstrueux"
    ],
    "sexe": {
    "male": 50,
    "female": 50
},
    "catch_rate": 45,
    "level_100": 1250000,
    "formes": null
}*/

/* Classe représentant un Pokemon et ses attributs */
data class Pokemon(
    val pokedex_id: Int,
    val generation: Int,
    val category: String,
    val name: Name,
    val sprites: Sprites,
    val types: List<Type>,
    val stats: Stats,
)

/* Enum des differents nom des pokemons */
public  class Name(
    val fr: String,
    val en: String,
    val jp: String

)
/*Enum des differents sprites du pokemons*/

public  class Sprites(
    val regular: String,
    val shiny: String,
    val gmax: String?

)

/*Représente differents types du pokemon */
public  class Type(
    val name: String,
    val image: String

)


public class Stats(
    val hp: Int,
    val atk: Int,
    val def: Int,
    val spe_atk: Int,
    val spe_def: Int,
)


