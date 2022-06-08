package com.example.finalprojecttemplate.domain.models

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "theme_data_back_up_table")
data class ThemeDataModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val image: Uri,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val heightWidthRatio: Float,
    @ColumnInfo
    val flashcard: List<VocabularyForTheme>
) {
    companion object {
        fun emptyThemeDataModel() = ThemeDataModel(
            id = -1,
            image = "".toUri(),
            heightWidthRatio = 375f/563f,
            name = "",
            flashcard = listOf()
        )
    }
}

data class VocabularyForTheme(
    val id: Int,
    val word: String,
    val chinese: String,
    val positionForClickButton: Coordinate,
): Serializable

data class Coordinate(
    val x: Float,
    val y: Float
): Serializable