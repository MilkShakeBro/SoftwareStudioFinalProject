package com.example.finalprojecttemplate

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.ViewModel
import com.example.finalprojecttemplate.databinding.ResultPageScreenshotLayoutBinding

class ResultPageViewModel: ViewModel() {

    var screenshotLayoutBinding: ResultPageScreenshotLayoutBinding? = null

    fun getLayoutScreenShot(scaleDp: Float): Bitmap? {
        if (screenshotLayoutBinding == null) return null

        val frameLayout = screenshotLayoutBinding!!.screenshotLayout

        frameLayout.measure(
            View.MeasureSpec.makeMeasureSpec((300 * scaleDp).toInt(), View.MeasureSpec.EXACTLY),
            View.MeasureSpec.makeMeasureSpec((630 * scaleDp).toInt(), View.MeasureSpec.EXACTLY)
        )
        frameLayout.layout(0, 0, frameLayout.measuredWidth, frameLayout.measuredHeight)

        val bitmap = Bitmap.createBitmap(frameLayout.width, frameLayout.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        frameLayout.draw(canvas)

        return bitmap
    }
}