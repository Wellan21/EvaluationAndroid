package com.example.evaluationkotlin.nativeManagement

import android.content.Context
import android.media.MediaPlayer
import com.example.evaluationkotlin.R
// Permet de jouer un son lors d'un évènement
fun playBeeb(context: Context) {
    MediaPlayer.create(context, R.raw.beep).start()
}

