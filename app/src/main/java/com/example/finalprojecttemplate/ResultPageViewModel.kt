package com.example.finalprojecttemplate

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.view.View
import android.widget.FrameLayout
import androidx.lifecycle.ViewModel
import com.example.finalprojecttemplate.databinding.ResultPageScreenshotLayoutBinding
import java.io.File
import java.io.FileOutputStream

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

    private fun createTempFileInCache(context: Context, fileName: String, subFileName: String): File {
        val outputDir = context.cacheDir
        return File.createTempFile(fileName, subFileName, outputDir)
    }

    fun storeBitmapAsTempFile(context: Context, fileName: String, subFileName: String): Uri? {
        if (resultBitmap == null) return null

        val tempFile = createTempFileInCache(context, fileName, subFileName)
        val fileOuputStream = FileOutputStream(tempFile)
        resultBitmap!!.compress(Bitmap.CompressFormat.PNG, 100, fileOuputStream)

        return Uri.parse(tempFile.path)
    }
}