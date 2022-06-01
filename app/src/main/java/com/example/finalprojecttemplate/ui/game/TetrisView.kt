package com.example.finalprojecttemplate.ui.game

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.ui.game.GameConstant.DEFAULT_HORIZONTAL_SIZE
import com.example.finalprojecttemplate.ui.game.GameConstant.DEFAULT_VERTICAL_SIZE
import java.lang.Math.*
import kotlin.math.atan2

class TetrisView(context: Context, attrs: AttributeSet): View(context, attrs) {

    // previous touched coordinate
    private var previousX = 0f
    private var previousY = 0f

    // number of blocks of each side
    private var horizontalBlocksCount = DEFAULT_HORIZONTAL_SIZE
    private var verticalBlocksCount = DEFAULT_VERTICAL_SIZE

    // size of the block
    private val horizontalBlockSize: Float
        get() = width.toFloat() / horizontalBlocksCount
    private val verticalBlockSize: Float
        get() = height.toFloat() / verticalBlocksCount

    // size of the text on the view
    private var textSize = 0f

    // font family, will be given by the activity
    var fontFamily: Typeface? = Typeface.MONOSPACE

    var tetrisGameState: TetrisState? = null

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TetrisView,
            0, 0).apply {
            try {
                horizontalBlocksCount = getInteger(R.styleable.TetrisView_horizontalBlocksCount, DEFAULT_HORIZONTAL_SIZE)
                verticalBlocksCount = getInteger(R.styleable.TetrisView_horizontalBlocksCount, DEFAULT_VERTICAL_SIZE)
                textSize = getDimension(R.styleable.TetrisView_android_textSize, 0f)
            } finally {
                recycle()
            }
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (tetrisGameState == null) return

        val backgroundPaint = Paint()
        backgroundPaint.color = Color.TRANSPARENT
        backgroundPaint.style = Paint.Style.FILL

        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        drawSelectedRowBackground(canvas)
        drawText(canvas)
//        drawFrame(canvas)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        super.onTouchEvent(event)

        if (event == null) return false
        if (tetrisGameState == null) return false

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                previousX = event.x
                previousY = event.y
            }
            MotionEvent.ACTION_UP -> {
                tetraminoGoDir(getDirection(previousX, previousY, event.x, event.y))
                invalidate()
            }
        }
        return true
    }

    private fun drawSelectedRowBackground(canvas: Canvas?) {
        if (tetrisGameState == null) return
        val grayPaint = Paint()
        grayPaint.color = GameColor.LIGHT_PLUM
        grayPaint.style = Paint.Style.FILL

        val rectUpperBound = (tetrisGameState!!.tetramino.position.y * verticalBlockSize).toInt()
        val selectedRow = Rect(0, rectUpperBound, width, (rectUpperBound + verticalBlockSize).toInt())
        canvas?.drawRect(selectedRow, grayPaint)
    }

    private fun drawFrame(canvas: Canvas?) {
        val horizontalSize = width / horizontalBlocksCount
        val verticalSize = height / verticalBlocksCount

        // paint style
        val framePaint = Paint()
        framePaint.style = Paint.Style.STROKE
        framePaint.color = GameColor.WHITE
        framePaint.strokeWidth = 5f

        // draw frame
        for(x in 0..width step horizontalSize) {
            canvas?.drawLine(x.toFloat(), 0f, x.toFloat(), height.toFloat(), framePaint)
        }
        for(y in 0..height step verticalSize) {
            canvas?.drawLine(0f, y.toFloat(), width.toFloat(), y.toFloat(), framePaint)
        }
    }

    private fun drawText(canvas: Canvas?) {
        if (tetrisGameState == null) return

        val whitePaint = Paint()
        whitePaint.color = GameColor.WHITE
        whitePaint.textAlign = Paint.Align.CENTER
        whitePaint.style = Paint.Style.FILL
        whitePaint.textSize = textSize-10f
        whitePaint.typeface = fontFamily

        val orangePaint = Paint()
        orangePaint.color = GameColor.GOLD
        orangePaint.textAlign = Paint.Align.CENTER
        orangePaint.style = Paint.Style.FILL
        orangePaint.textSize = textSize-10f
        orangePaint.typeface = fontFamily

//        var numOfm: Int = 0

        for (y in 0 until verticalBlocksCount) {
            for (x in 0 until horizontalBlocksCount) {

//                if (tetrisGameState!!.tetrisArray[y][x].toString() == "m" || (x>0 && tetrisGameState!!.tetrisArray[y][x-1].toString() == "m")) numOfm++

                val startPoint = getStartPosition(x, y, 0)
                val horizontalBlockSizeConsiderM =
                    if(tetrisGameState!!.tetrisArray[y][x] == 'm') horizontalBlockSize.toInt() * 2
                    else horizontalBlockSize

                val baseline = getBaseline(startPoint.x, startPoint.y, horizontalBlockSizeConsiderM.toInt(), verticalBlockSize.toInt(), whitePaint)
                val rect = Rect(startPoint.x, startPoint.y, startPoint.x + horizontalBlockSizeConsiderM.toInt(), startPoint.y + verticalBlockSize.toInt())

                when (tetrisGameState!!.tetrisState[y][x]) {
                    BlockState.OCCUPIED -> canvas?.drawText(
                        tetrisGameState!!.tetrisArray[y][x].toString(),
                        rect.centerX().toFloat(),
                        baseline,
                        whitePaint
                    )
                    BlockState.BLANK -> canvas?.drawText(
                        " ",
                        rect.centerX().toFloat(),
                        baseline,
                        whitePaint
                    )
                    BlockState.SUFFIX -> canvas?.drawText(
                        tetrisGameState!!.tetrisArray[y][x].toString(),
                        rect.centerX().toFloat(),
                        baseline,
                        orangePaint
                    )
                }
            }
        }
    }

    private fun getStartPosition(x: Int, y: Int, numOfm: Int): Point {
        return Point((x * horizontalBlockSize + numOfm * 20).toInt(), (y * verticalBlockSize).toInt())
    }

    private fun getDirection(previousX: Float, previousY: Float, nowX: Float, nowY: Float) : Direction {
        val angle = atan2((nowY - previousY), (nowX - previousX))
        return if (angle >= - PI / 4f && angle <= PI / 4f) Direction.RIGHT
        else if (angle >= PI / 4f && angle <= PI * 3f / 4f) Direction.DOWN
        else if (angle >= - PI * 3f / 4f && angle <= - PI / 4f) Direction.UP
        else Direction.LEFT
    }

    private fun getBaseline(startX: Int, startY: Int, offsetX: Int, offsetY: Int, paint: Paint): Float {
        val rect = Rect(startX, startY, startX + offsetX, startY + offsetY)
        val fontMetrics = paint.fontMetrics
        val distance = (fontMetrics.bottom - fontMetrics.top) / 2f - fontMetrics.bottom
        return rect.centerY() + distance
    }

    fun tetraminoGoDir(dir: Direction) {
        if (tetrisGameState == null) return
        if (dir == Direction.RIGHT) return
        if (width <= 0.5) return

        tetrisGameState!!.makeTetraminoGoDir(dir, horizontalBlocksCount, verticalBlocksCount)
    }

    fun tetraminoGoLeftMost() {

        tetrisGameState?.apply {
            if (tetrisGameState!!.tetramino.position.x <= DEFAULT_HORIZONTAL_SIZE - 1)
                tetrisGameState!!.makeTetraminoGoLeftMost(horizontalBlocksCount, verticalBlocksCount)
        }
    }

    fun update(/*score: TextView*/) {
        if (tetrisGameState == null) return

        tetrisGameState!!.updatePeriodCount += 1
        if (tetrisGameState!!.updatePeriodCount == 49) {
            tetrisGameState!!.updatePeriodCount = 0
            tetraminoGoDir(Direction.LEFT)
        }

//        score.text = tetrisGameState!!.score.toString()
        invalidate()
    }

    fun setTetrisState(tetrisState: TetrisState) {
        tetrisGameState = tetrisState
    }

    fun getChineseMeaning(): String? {
        return tetrisGameState?.getChineseMeaning()
    }

    fun setOnMatchWord(func: () -> Unit) {
        tetrisGameState?.onMatchWord = func
    }
}