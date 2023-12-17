package com.parstasmim.mylibrary.utils

import android.graphics.Color
import javax.inject.Inject

interface IRandomColorGenerator {
    fun getRandomColor(): Int
}

class RandomColorGenerator @Inject constructor() : IRandomColorGenerator {
    override fun getRandomColor(): Int {
        // Generate random RGB values
        val red = (0..255).random()
        val green = (0..255).random()
        val blue = (0..255).random()
        // Combine RGB values into a single color integer
        return Color.rgb(red, green, blue)
    }
}