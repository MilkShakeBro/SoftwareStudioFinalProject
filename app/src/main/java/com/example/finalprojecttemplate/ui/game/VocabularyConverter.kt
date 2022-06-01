package com.example.finalprojecttemplate.ui.game

import android.util.Log
import com.example.finalprojecttemplate.domain.models.Vocabulary

fun Vocabulary.toTetrisVocabulary() = run {
    val chineseMeaning = chinese
    val prefixRowWithoutHandlingFatChar = Array<Char>(GameConstant.DEFAULT_HORIZONTAL_SIZE) { idx ->
        if (idx < breakpoint) word[idx]
        else '*'
    }.joinToString(separator = "")
    val suffixRowWithoutHandlingFatChar = word.substring(breakpoint)
    val answerRowWithoutHandlingFatChar = Array<Char>(GameConstant.DEFAULT_HORIZONTAL_SIZE) { idx ->
        if (idx < word.length) word[idx]
        else '*'
    }.joinToString(separator = "")

    Log.d("TetrisGameViewModel", suffixRowWithoutHandlingFatChar)

    TetrisVocabulary(
        prefixRow = handleFatCharacterM(prefixRowWithoutHandlingFatChar),
        suffixRow = handleFatCharacterM(suffixRowWithoutHandlingFatChar),
        chineseMeaning = chineseMeaning,
        answerRow = handleFatCharacterM(answerRowWithoutHandlingFatChar)
    )
}

private fun handleFatCharacterM(original: String) : String {
    val tempList = mutableListOf<Char>()

    var lagCount = 0
    for(c in original) {
        if (c == 'm') {
            tempList.add(c)
            tempList.add(' ')
            lagCount += 1
        } else if (c == '*') {
            if (lagCount > 0) lagCount -= 1
            else tempList.add('*')
        } else tempList.add(c)
    }

    return tempList.joinToString(separator = "")
}

/**
 * data class Vocabulary (
 * val id: Int,
 * val word: String,
 * val chinese: String,
 * val breakpoint: Int
 * )
 */

/**
 * data class TetrisVocabulary (
 * val prefixRow: String,
 * val suffixRow: String,
 * val answerRow: String,
 * val chineseMeaning: String
 * )
 */