package com.example.finalprojecttemplate.domain.models

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "vocabulary_set_backup_table")
data class VocabularySetModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val image: Uri,
    @ColumnInfo
    val vocabularySet: List<Vocabulary>,
) {
    companion object {
        fun emptyVocabularySetModel()
        = VocabularySetModel(
            id = -1,
            name = "",
            image = "".toUri(),
            vocabularySet = listOf()
        )
    }
}

data class HistoryVocabularySetRecord(
    val lastVocabularySet: List<Vocabulary>,
    val lastVocabularyId: Int,
    val score: Int,
    val time: Int
)

data class Vocabulary (
    val id: Int,
    val word: String,
    val chinese: String,
    val breakpoint: Int
) : Serializable