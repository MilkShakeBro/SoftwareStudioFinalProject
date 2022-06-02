package com.example.finalprojecttemplate.ui.game

import android.content.res.Resources
import android.graphics.Point
import android.util.Log
import androidx.core.graphics.plus
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.domain.models.Vocabulary
import com.example.finalprojecttemplate.ui.game.GameConstant.DEFAULT_HORIZONTAL_SIZE

private const val TAG = "TetrisState"

class TetrisState(val tetrisVocabularyArray : Array<TetrisVocabulary>) {

//    // This is the array that record the original game board
//    var tetrisArrayOriginal: Array<CharArray> = resources.getStringArray(R.array.vocabulary_tetris).map { str ->
//        handleFatCharacterM(str).toCharArray()
//    }.toTypedArray()
//
//    // This is the array stores the suffixes
//    var suffixArray: Array<String> = resources.getStringArray(R.array.vocabularies_suffix).map { str ->
//        handleFatCharacterM(str).joinToString(separator = "")
//    }.toTypedArray()
//
//    // The array stores the chinese meaning
//    var chineseArray: Array<String> = resources.getTextArray(R.array.chinese_meaning).map { str ->
//        str.toString()
//    }.toTypedArray()
//
//    // The array stores the correct answers.
//    var answerArray: Array<CharArray> = resources.getStringArray(R.array.vocabularies).map { str ->
//        handleFatCharacterM(str).toCharArray()
//    }.toTypedArray()

//    private lateinit var tetrisVocabularyArray: Array<TetrisVocabulary>

    // This is the array that record the text shown on the game board
//    var tetrisArray: Array<CharArray> = resources.getStringArray(R.array.vocabulary_tetris).map { str ->
//        handleFatCharacterM(str).toCharArray()
//    }.toTypedArray()
    val tetrisArray: Array<CharArray> = tetrisVocabularyArray.map { tetrisVoc ->
        tetrisVoc.prefixRow.toCharArray()
    }.toTypedArray()

    // The state of the each block in the game board.
    // There are 3 possible states: BLANK, OCCUPIED (by the prefix), BLANK
    val tetrisState: Array<Array<BlockState>> = tetrisArray.map { charArray ->
        charArray.map { char ->
            if (char == '*') BlockState.BLANK
            else BlockState.OCCUPIED
        }.toTypedArray()
    }.toTypedArray()

    // Count the number of updates  (in unit 20ms)
    var updatePeriodCount = 0

    // Count of the answer
    var answerCount: Int = 0

    // Count of the suffix
    var suffixCount: Int = 0

    // Score
//    var score: Int = 0
    private val _score = MutableLiveData<Int>(0)
    val score: LiveData<Int> = _score

    var tetramino = Tetramino(tetrisVocabularyArray[0].suffixRow)

    private val _gameState = MutableLiveData<GameState>(GameState.PAUSE)
    val gameState : LiveData<GameState>
        get() = _gameState

    var onMatchWord: () -> Unit = {}

    init {
        tetramino.setPosition(Point(DEFAULT_HORIZONTAL_SIZE, 5))
//        tetrisArray = Array(GameConstant.VOCABULARY_COUNT) { idx ->
//            tetrisVocabularyArray[idx].prefixRow.toCharArray()
//        }
    }

//    private fun initialTetrisVocabulary(resources: Resources) : Array<TetrisVocabulary> {
//        // This is the array that record the original game board
//        val tetrisArrayOriginal: Array<String> = resources.getStringArray(R.array.vocabulary_tetris).map { str ->
//            handleFatCharacterM(str).joinToString(separator = "")
//        }.toTypedArray()
//
//        // This is the array stores the suffixes
//        val suffixArray: Array<String> = resources.getStringArray(R.array.vocabularies_suffix).map { str ->
//            handleFatCharacterM(str).joinToString(separator = "")
//        }.toTypedArray()
//
//        // The array stores the chinese meaning
//        val chineseArray: Array<String> = resources.getTextArray(R.array.chinese_meaning).map { str ->
//            str.toString()
//        }.toTypedArray()
//
//        // The array stores the correct answers.
//        val answerArray: Array<String> = resources.getStringArray(R.array.vocabularies).map { str ->
//            handleFatCharacterM(str).joinToString(separator = "")
//        }.toTypedArray()
//
//        return Array(GameConstant.VOCABULARY_COUNT) { idx ->
//            TetrisVocabulary(
//                prefixRow = tetrisArrayOriginal[idx],
//                suffixRow = suffixArray[idx],
//                answerRow = answerArray[idx],
//                chineseMeaning = chineseArray[idx]
//            )
//        }
//    }


    fun startGame() {
        _gameState.value = GameState.PLAY
    }

    fun getChineseMeaning(): String {
        return if (tetramino.position.y < 0) "GAME OVER"
//        else chineseArray[tetramino.position.y]
        else tetrisVocabularyArray[tetramino.position.y].chineseMeaning
    }

    fun makeTetraminoGoDir(dir: Direction, horizontalBlocksCount: Int, verticalBlocksCount: Int) {
        if (dir == Direction.RIGHT) return
        if (gameState.value != GameState.PLAY) return

        val tetraminoNowPos = tetramino.getNextPositionIfShift(dir)
        val tetraminoOldPos = tetramino.getCurrentPosition()

        // Chinese meaning change
        if (dir == Direction.DOWN) {
            Log.d("wtf is this", tetrisVocabularyArray[0].chineseMeaning) }
//        } else if (dir == Direction.UP) {
//            chineseMeaning =
//        }

        // Touch check
        val touched = isTouched(tetraminoNowPos, horizontalBlocksCount, verticalBlocksCount)

        // Valid action check
        var isValid = true
        for (pt in tetraminoNowPos) {
            isValid = isValid.and(notExceedVerticalLeftBound(pt.x, pt.y, verticalBlocksCount))
        }

        if (touched || !isValid) {
            if (dir == Direction.LEFT) {
                checkTheAnswer(tetramino.position.y, horizontalBlocksCount, verticalBlocksCount)
                suffixCount += 1
//                if (suffixCount == suffixArray.size || answerCount == (answerArray.size - horizontalBlocksCount - 1)) {
                if (suffixCount == GameConstant.VOCABULARY_COUNT ||
                    answerCount == (GameConstant.VOCABULARY_COUNT - horizontalBlocksCount - 1)) {
                    _gameState.value = GameState.END
                }
                else {
//                    tetramino = Tetramino(suffixArray[suffixCount])
                    tetramino = Tetramino(tetrisVocabularyArray[suffixCount].suffixRow)
                    tetramino.setPosition(Point(DEFAULT_HORIZONTAL_SIZE, 5))
                }
                updatePeriodCount = 0
            }
        }
        else {

            updateTetramino(
                tetraminoOldPos = tetraminoOldPos,
                tetraminoNowPos = tetraminoNowPos,
                tetraminoWord = tetramino.word,
                horizontalBlocksCount = horizontalBlocksCount,
                verticalBlocksCount = verticalBlocksCount
            )

            tetramino.goNextPosition(dir)

            if (dir == Direction.LEFT) updatePeriodCount = 0
        }
    }

    fun makeTetraminoGoLeftMost(horizontalBlocksCount: Int, verticalBlocksCount: Int) {
        var firstOccupiedX = tetramino.position.x
        while (coordinateIsValid(firstOccupiedX, tetramino.position.y, horizontalBlocksCount, verticalBlocksCount)
            && tetrisState[tetramino.position.y][firstOccupiedX] != BlockState.OCCUPIED
        ) {
            firstOccupiedX -= 1
        }

        val tetraminoOldPos = tetramino.getCurrentPosition()

        val tetraminoNowPos = tetramino.arrangement.map { pos ->
            pos + Point(firstOccupiedX + 1, tetramino.position.y)
        }

        updateTetramino(
            tetraminoOldPos = tetraminoOldPos,
            tetraminoNowPos = tetraminoNowPos,
            tetraminoWord = tetramino.word,
            horizontalBlocksCount = horizontalBlocksCount,
            verticalBlocksCount = verticalBlocksCount
        )

        tetramino.setPosition(Point(firstOccupiedX + 1, tetramino.position.y))
    }

    private fun updateTetramino(tetraminoOldPos: List<Point>, tetraminoNowPos: List<Point>, tetraminoWord: String, horizontalBlocksCount: Int, verticalBlocksCount: Int) {
        for (pt in tetraminoOldPos) {
            if (coordinateIsValid(pt.x, pt.y, horizontalBlocksCount, verticalBlocksCount)) {
                tetrisState[pt.y][pt.x] = BlockState.BLANK
                tetrisArray[pt.y][pt.x] = '*'
            }
        }
        var charCount = 0
        for (pt in tetraminoNowPos) {
            if (coordinateIsValid(pt.x, pt.y, horizontalBlocksCount, verticalBlocksCount)) {
                tetrisState[pt.y][pt.x] = BlockState.SUFFIX
                tetrisArray[pt.y][pt.x] = tetraminoWord[charCount]
                charCount += 1
            }
        }
    }

    private fun isTouched(newPosition: List<Point>, horizontalBlocksCount: Int, verticalBlocksCount: Int) : Boolean {
        var touched = false
        for (pt in newPosition) {
            if (coordinateIsValid(pt.x, pt.y, horizontalBlocksCount, verticalBlocksCount)) {
                if (tetrisState[pt.y][pt.x] == BlockState.OCCUPIED) touched = true
            }
        }
        return touched
    }

    private fun coordinateIsValid(x: Int, y: Int, horizontalBlocksCount: Int, verticalBlocksCount: Int) : Boolean{
        return (x in 0 until horizontalBlocksCount && y in 0 until verticalBlocksCount)
    }

    private fun notExceedVerticalLeftBound(x: Int, y: Int, verticalBlocksCount: Int): Boolean {
        return (x >= 0 && y in 0 until verticalBlocksCount)
    }

    private fun checkTheAnswer(verticalPosition: Int, horizontalBlocksCount: Int, verticalBlocksCount: Int) {
        if (verticalPosition >= verticalBlocksCount || verticalPosition < 0) return
//        val isCorrect = tetrisArray[verticalPosition].contentEquals(answerArray[verticalPosition])
        val isCorrect = tetrisArray[verticalPosition].contentEquals(tetrisVocabularyArray[verticalPosition].answerRow.toCharArray())

        if (isCorrect) {
            _score.value = _score.value!! + 10
            if (verticalBlocksCount + answerCount < GameConstant.VOCABULARY_COUNT) {
                tetrisArray[verticalPosition] = deepCopyCharArray(tetrisArray[verticalBlocksCount + answerCount])
//                chineseArray[verticalPosition] = chineseArray[verticalBlocksCount + answerCount]
//                tetrisArrayOriginal[verticalPosition] = deepCopyCharArray(tetrisArrayOriginal[verticalBlocksCount + answerCount])
//                answerArray[verticalPosition] = deepCopyCharArray(answerArray[verticalBlocksCount + answerCount])
                tetrisVocabularyArray[verticalPosition] = tetrisVocabularyArray[verticalBlocksCount + answerCount]
            } else {

                val emptyTetrisRow = MutableList<Char>(horizontalBlocksCount, ) { _ ->
                    '*'
                }.joinToString(separator = "")

                tetrisArray[verticalPosition] = deepCopyCharArray(emptyTetrisRow.toCharArray())
//                chineseArray[verticalPosition] = ""
//                tetrisArrayOriginal[verticalPosition] = deepCopyCharArray(emptyTetrisRow.toCharArray())
//                answerArray[verticalPosition] = "I am not the answer!!".toCharArray()
                tetrisVocabularyArray[verticalPosition] =
                    TetrisVocabulary(
                        prefixRow = emptyTetrisRow,
                        suffixRow = "",
                        answerRow = "I am not the answer",
                        chineseMeaning = ""
                    )
            }
            answerCount++
            onMatchWord()
        } else {
//            tetrisArray[verticalPosition] = deepCopyCharArray(tetrisArrayOriginal[verticalPosition])
            tetrisArray[verticalPosition] = tetrisVocabularyArray[verticalPosition].prefixRow.toCharArray()
        }

        for (x in 0 until horizontalBlocksCount) {
            if (tetrisArray[verticalPosition][x] == '*') {
                tetrisState[verticalPosition][x] = BlockState.BLANK
            }
            else {
                tetrisState[verticalPosition][x] = BlockState.OCCUPIED
            }
        }
    }

    private fun handleFatCharacterM(original: String) : List<Char> {
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

        return tempList
    }

    private fun deepCopyCharArray(beCopied: CharArray) = beCopied.toList().toCharArray()
}

/*
* */