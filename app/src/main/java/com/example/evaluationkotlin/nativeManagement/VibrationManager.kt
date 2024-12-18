package com.example.evaluationkotlin.nativeManagement


import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator

class VibrationManager(private val context: Context) {
    private val vibrator: Vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    /*
      Fonction pour faire vibrer le téléphone
     */
    public fun vibratePhone() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Pour Android Oreo (API 26) et versions supérieures
            val vibrationEffect =
                VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE)
            vibrator.vibrate(vibrationEffect)
        } else {
            // Pour les anciennes versions d'Android
            @Suppress("DEPRECATION")
            vibrator.vibrate(200)
        }
    }
}