package com.example.finalprojecttemplate.domain.models

import android.net.Uri
import java.io.Serializable

data class VocabularySetModel(
    val id: Int,
    val name: String,
    val image: Uri,
    val vocabularySet: List<Vocabulary>,
)

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