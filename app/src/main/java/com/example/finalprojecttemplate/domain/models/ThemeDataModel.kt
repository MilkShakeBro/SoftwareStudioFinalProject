package com.example.finalprojecttemplate.domain.models

import android.net.Uri

data class ThemeDataModel(
    val id: Int,
    val image: Uri,
    val flashcard: List<VocabularyForTheme>
)

data class VocabularyForTheme(
    val id: Int,
    val word: String,
    val chinese: String,
    val positionForClickButton: Coordinate,
)

data class Coordinate(
    val x: Float,
    val y: Float
)