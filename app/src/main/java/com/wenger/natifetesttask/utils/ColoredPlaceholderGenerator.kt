package com.wenger.natifetesttask.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.wenger.natifetesttask.R

object ColoredPlaceholderGenerator {

    private val placeholderColors = arrayOf(
        R.color.colorLightGreen,
        R.color.colorLightBlue,
        R.color.colorLightPurple,
        R.color.colorLightRed,
        R.color.colorLightYellow
    )

    fun generate(context: Context): Int {
        val randomIndex = (1..placeholderColors.size).random()
        return ContextCompat.getColor(context, placeholderColors[randomIndex - 1])
    }
}