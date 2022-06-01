package com.example.finalprojecttemplate

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.net.Uri
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import com.example.finalprojecttemplate.databinding.ResultPageScreenshotLayoutBinding
import java.io.File
import java.io.FileOutputStream
import java.util.*

private val FILE_PROVIDER_AUTHORITY = "com.example.finalprojecttemplate.provider"

class ResultPageViewModel: ViewModel() {

    var screenshotLayoutBinding: ResultPageScreenshotLayoutBinding? = null

    var screenScore = 0
    var screenPlayerName = ""
    var screenTags = ""

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

        screenshotLayoutBinding!!.apply {
            score.text = screenScore.toString()
            playerName.text = screenPlayerName
            tagText.text = screenTags
        }

        val bitmap = Bitmap.createBitmap(frameLayout.width, frameLayout.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        frameLayout.draw(canvas)

        _resultBitmap = bitmap
    }

    fun saveImage(bitmap: Bitmap, context: Context) : Uri? {
        val imageFolder = File(context.cacheDir, "images")
        var imageUri : Uri? = null

        try {
            imageFolder.mkdir()
            val file = File(imageFolder, "shared_image.jpg")

            val outputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            outputStream.flush()
            outputStream.close()

            imageUri = FileProvider.getUriForFile(
                Objects.requireNonNull(context.applicationContext),
                FILE_PROVIDER_AUTHORITY,
                file
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return imageUri
    }
}