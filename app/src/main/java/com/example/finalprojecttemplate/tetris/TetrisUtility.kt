package com.example.finalprojecttemplate.tetris

import android.content.res.Resources
import android.graphics.Color
import android.graphics.Point
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

object GameColor {
    val ORANGE = Color.parseColor("#F8B200")
    val DKGRAY = Color.parseColor("#3F3E3E")
    val WHITE = Color.WHITE
    val GRAY = Color.parseColor("#7E7E7E")
    val GOLD = Color.parseColor("#FFD966")
    val LIGHT_PLUM = Color.parseColor("#BD708B")
}

object DirectionVector {
    val LEFT = Point(-1, 0)
    val RIGHT = Point(1, 0)
    val UP = Point(0, -1)
    val DOWN = Point(0, 1)

    fun getDirectionVector(dir: Direction): Point {
        return when (dir) {
            Direction.LEFT -> LEFT
            Direction.RIGHT -> RIGHT
            Direction.UP -> UP
            Direction.DOWN -> DOWN
        }
    }
}

enum class Direction { UP, DOWN, LEFT, RIGHT }

enum class BlockState { OCCUPIED, SUFFIX, BLANK }

enum class GameState { PAUSE, PLAY, END }

object GameConstant {
    const val DEFAULT_HORIZONTAL_SIZE = 22
    const val DEFAULT_VERTICAL_SIZE = 10
    const val VOCABULARY_COUNT = 18
}