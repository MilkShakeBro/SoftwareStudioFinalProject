package com.example.finalprojecttemplate

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.ViewModel
import com.example.finalprojecttemplate.databinding.ResultPageScreenshotLayoutBinding

class ResultPageViewModel: ViewModel() {

    var screenshotLayoutBinding: ResultPageScreenshotLayoutBinding? = null

    private var _resultBitmap : Bitmap? = null
    val resultBitmap: Bitmap?
        get() =
            if (_resultBitmap == null) {
                getLayoutScreenShot()
                _resultBitmap
            } else _resultBitmap

    private fun getLayoutScreenShot() {
        if (screenshotLayoutBinding == null) return

        val frameLayout = screenshotLayoutBinding!!.screenshotLayout

        frameLayout.measure(
            View.MeasureSpec.makeMeasureSpec(1023, View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec(2133, View.MeasureSpec.EXACTLY)
        )
        frameLayout.layout(0, 0, frameLayout.measuredWidth, frameLayout.measuredHeight)

        val bitmap = Bitmap.createBitmap(frameLayout.width, frameLayout.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        frameLayout.draw(canvas)

        _resultBitmap = bitmap
    }
}