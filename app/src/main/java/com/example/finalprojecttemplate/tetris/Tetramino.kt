package com.example.finalprojecttemplate.tetris

import android.graphics.Point
import androidx.core.graphics.plus

class Tetramino(val word: String) {

    val length get() = word.length
    val arrangement: List<Point> = initializeArrangement()

    private var _position = Point(0, 0)
    val position get() = _position

    private fun initializeArrangement() : List<Point> {
        val tempList = mutableListOf<Point>()
        for (i in 0 until length) {
            tempList.add(Point(i, 0))
        }
        return tempList
    }

    fun getCurrentPosition(): List<Point> {
        return arrangement.map { pt ->
            pt + position
        }
    }

    fun getNextPositionIfShift(direction: Direction) : List<Point> {
        val offset = DirectionVector.getDirectionVector(direction)
        return arrangement.map { pt ->
            pt + position + offset
        }
    }

    fun goNextPosition(dir: Direction) {
        _position += DirectionVector.getDirectionVector(dir)
    }

    fun setPosition(pos: Point) {
        _position = pos
    }
}