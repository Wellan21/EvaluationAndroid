package com.example.evaluationkotlin.nativeManagement

import android.content.Context
import android.media.MediaPlayer
import com.example.evaluationkotlin.R

fun playBeeb(context: Context) {
    MediaPlayer.create(context, R.raw.beep).start()
}

