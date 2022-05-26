package com.example.finalprojecttemplate.fragments

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.finalprojecttemplate.BuildConfig
import com.example.finalprojecttemplate.ResultPageViewModel
import com.example.finalprojecttemplate.databinding.ResultPageFragmentBinding
import com.example.finalprojecttemplate.databinding.ResultPageScreenshotLayoutBinding
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


class ResultPageFragment: Fragment()  {

    private var binding: ResultPageFragmentBinding? = null

    private val viewModel: ResultPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = ResultPageFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.screenshotLayoutBinding = ResultPageScreenshotLayoutBinding.inflate(layoutInflater)

        binding?.apply {

            screenshotCheckWindowLayout.visibility = View.GONE

            confirmButton.setOnClickListener {
                Toast.makeText(context, "Confirm button is unavailable now.", Toast.LENGTH_SHORT).show()
            }

            againButton.setOnClickListener {
//                val action = ResultPageFragmentDirections.actionResultPageFragmentToGamePageFragment()
//                findNavController().navigate(action)
                navigateBackToGamePage()
            }

            shareButton.setOnClickListener {
                shareBitmap(viewModel.resultBitmap)
            }

            screenshotButton.setOnClickListener {
                screenshotCheckWindowLayout.visibility = View.VISIBLE
                screenshotImage.setImageBitmap(viewModel.resultBitmap)
            }

            cancelScreenshotButton.setOnClickListener {
                screenshotCheckWindowLayout.visibility = View.GONE
            }

            val score = arguments?.getInt("score") ?: 0
            scoreTextView.text = score.toString()
            rankDescription.text = "1st!"
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigateBackToGamePage()
            }
        }

        activity?.onBackPressedDispatcher?.addCallback(this, callback)
    }

    private fun navigateBackToGamePage() {
        // TODO: Add the direction from result page to game page
//        val action = ResultPageFragmentDirections.actionResultPageFragmentToGamePageFragment()
//        findNavController().navigate(action)
    }

    private fun shareBitmap(bitmap: Bitmap?) {
        if (bitmap == null) return

        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "image/*"
        sharingIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        sharingIntent.putExtra(Intent.EXTRA_STREAM, saveImage(bitmap, requireContext()))
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "Game2Mem")
        startActivity(Intent.createChooser(sharingIntent, "Share Image"))
    }

    private fun saveImage(bitmap: Bitmap, context: Context) : Uri? {
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
                "com.example.finalprojecttemplate" + ".provider",
                file
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return imageUri
    }
}