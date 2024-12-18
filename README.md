# Evaluation Android

Ce projet implémente l'api Tryadex qui permet de recuperer les données des pokémons en français. 

 # Pourquoi Tryadex

J'ai choisi l'api Tryadex car elle recupre des données en français et que la structure des donnés me semblait facilement utilisable. 

## Foncionalitées Implémentées 
j'ai implémenté : 
- Une page listant different pokemon
- Lorsque l'on clique sur un pokemon le téléphone vibre et émet un son issus des jeux pokemons
- Une page affichant les sprites du pokemon ainsi que diverse informations.
- Un mode sombre
- Une version Anglaise
## Choix technique 
- Données mooké
- utilisation de repository et de viewModelx

# Archtecture de l'application 
```
└── Wellan21-EvaluationAndroid
    └── app
        ├── .gitignore
        ├── proguard-rules.pro
        ├── build.gradle.kts
        └── src
            ├── main
            │   ├── AndroidManifest.xml
            │   ├── java
            │   │   └── com
            │   │       └── example
            │   │           └── evaluationkotlin
            │   │               ├── domain
            │   │               │   └── models
            │   │               │       └── Pokemon.kt
            │   │               ├── nativeManagement
            │   │               │   ├── VibrationManager.kt
            │   │               │   └── playSound.kt
            │   │               ├── data
            │   │               │   ├── repositories
            │   │               │   │   └── PokemonRepository.kt
            │   │               │   └── datasources
            │   │               │       └── MookedData.kt
            │   │               ├── ui
            │   │               │   ├── screens
            │   │               │   │   ├── pokemonList
            │   │               │   │   │   ├── PokemonListViewModel.kt
            │   │               │   │   │   └── PokemonListScreen.kt
            │   │               │   │   └── pokemon
            │   │               │   │       ├── PokemonScreen.kt
            │   │               │   │       └── PokemonScreenViewModel.kt
            │   │               │   └── theme
            │   │               │       ├── Theme.kt
            │   │               │       ├── Type.kt
            │   │               │       └── Color.kt
            │   │               └── MainActivity.kt
            │   └── res
            │       ├── xml
            │       │   ├── backup_rules.xml
            │       │   └── data_extraction_rules.xml
            │       ├── mipmap-mdpi
            │       │   ├── ic_launcher.webp
            │       │   └── ic_launcher_round.webp
            │       ├── mipmap-xxxhdpi
            │       │   ├── ic_launcher.webp
            │       │   └── ic_launcher_round.webp
            │       ├── mipmap-hdpi
            │       │   ├── ic_launcher.webp
            │       │   └── ic_launcher_round.webp
            │       ├── mipmap-xxhdpi
            │       │   ├── ic_launcher.webp
            │       │   └── ic_launcher_round.webp
            │       ├── drawable
            │       │   ├── ic_launcher_background.xml
            │       │   └── ic_launcher_foreground.xml
            │       ├── values-fr
            │       │   └── strings.xml
            │       ├── raw
            │       │   └── beep.mp3
            │       ├── mipmap-xhdpi
            │       │   ├── ic_launcher.webp
            │       │   └── ic_launcher_round.webp
            │       ├── values-night
            │       │   └── colors.xml
            │       ├── mipmap-anydpi
            │       │   ├── ic_launcher.xml
            │       │   └── ic_launcher_round.xml
            │       └── values
            │           ├── strings.xml
            │           ├── themes.xml
            │           └── colors.xml
            ├── test
            │   └── java
            │       └── com
            │           └── example
            │               └── evaluationkotlin
            │                   └── ExampleUnitTest.kt
            └── androidTest
                └── java
                    └── com
                        └── example
                            └── evaluationkotlin
                                └── ExampleInstrumentedTest.kt
```

  
