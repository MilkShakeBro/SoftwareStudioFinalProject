package com.example.finalprojecttemplate.ui.flashcard

import android.content.Context
import android.util.TypedValue

object GlobalFunctions {
    fun dpToPx(context: Context, dp: Float) =
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        )
}