package com.example.finalprojecttemplate

import android.content.Context
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.media.MediaScannerConnection.OnScanCompletedListener
import android.os.Environment
import android.util.Log
import java.io.File
import java.io.FileOutputStream


class FileHandler() {

    fun saveBitmapToExternalDirectory(context: Context, bitmap: Bitmap, fileName: String) {
        val root = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString()
        val imageDir = File("$root/GameToMem")
        imageDir.mkdir()

        val imageFile = File(imageDir, fileName)

        try {
            val outputStream = FileOutputStream(imageFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            outputStream.flush()
            outputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("FileHandler", e.message.toString())
        }

        // Tell the media scanner about the new file so that it is
        // immediately available to the user.
        MediaScannerConnection.scanFile(context, arrayOf(imageFile.toString()), null
        ) { path, uri ->
            Log.i("ExternalStorage", "Scanned $path:")
            Log.i("ExternalStorage", "-> uri=$uri")
        }

    }
}