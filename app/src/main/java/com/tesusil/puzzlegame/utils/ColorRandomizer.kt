package com.tesusil.puzzlegame.utils

import androidx.compose.ui.graphics.Color
import java.util.Random
import kotlin.math.abs

object ColorRandomizer {
    private val colorList = listOf(
        Color(0xFF2196F3), // Blue
        Color(0xFF4CAF50), // Green
        Color(0xFFE91E63), // Pink
        Color(0xFFFFC107), // Amber
        Color(0xFF9C27B0), // Purple
        Color(0xFF673AB7), // Deep Purple
        Color(0xFF3F51B5), // Indigo
        Color(0xFF00BCD4), // Cyan
        Color(0xFF009688), // Teal
        Color(0xFF795548), // Brown
        Color(0xFF607D8B), // Blue Grey
        Color(0xFFFF5722), // Deep Orange
        Color(0xFFCDDC39), // Lime Green
        Color(0xFFFFEB3B), // Yellow
        Color(0xFF8BC34A), // Light Green
        Color(0xFF03A9F4)  // Light Blue
    )

    fun getRandomColor(): Color {
        val random = Random()
        val randomIndex = abs(random.nextInt()) % colorList.lastIndex
        return colorList[randomIndex]
    }
}