package com.example.finalprojecttemplate.ui.game_result

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.PopupWindow
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.finalprojecttemplate.domain.utils.FileHandler
import com.example.finalprojecttemplate.databinding.ResultPageFragmentBinding
import com.example.finalprojecttemplate.databinding.ResultPageScreenshotLayoutBinding
import com.example.finalprojecttemplate.databinding.ScreenshotPopupWindowLayoutBinding
import java.util.*

class ResultPageFragment: Fragment()  {

    private var binding: ResultPageFragmentBinding? = null

    private var popUpWindowBinding: ScreenshotPopupWindowLayoutBinding? = null

    private var popUpWindow: PopupWindow? = null

    private val args : ResultPageFragmentArgs by navArgs()

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

        viewModel.apply {
            screenshotLayoutBinding = ResultPageScreenshotLayoutBinding.inflate(layoutInflater)
            screenPlayerName = "Chris Chen"
            screenScore = 130
            screenTags = "#HAHAHA #TESTINGTESTING #GAME2MEM #DEFEAT ALL PLAYERS #ANDROID STUDIO #KING OF VOCABULARIES"
        }

        binding?.apply {

            confirmButton.setOnClickListener {
//                Toast.makeText(context, "Confirm button is unavailable now.", Toast.LENGTH_SHORT).show()
                val action = ResultPageFragmentDirections.actionResultPageFragmentToHomePageFragment()
                findNavController().navigate(action)
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
//                screenshotCheckWindowLayout.visibility = View.VISIBLE
//                screenshotImage.setImageBitmap(viewModel.resultBitmap)
                initializePopWindow()
            }

            viewModel.screenScore = arguments?.getInt("score") ?: 0
            scoreTextView.text = viewModel.screenScore.toString()
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

    private fun initializePopWindow() {
        popUpWindowBinding = ScreenshotPopupWindowLayoutBinding.inflate(layoutInflater, null, false)
        popUpWindow = PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true)

        popUpWindow?.apply {
            contentView = popUpWindowBinding!!.root

            setBackgroundDrawable(ColorDrawable(Color.argb(220, 0, 0, 0)))

            showAtLocation(view, Gravity.CENTER, 0, 0)

            popUpWindowBinding?.apply {
                screenshotImage.setImageBitmap(viewModel.resultBitmap)
                saveImageButton.setOnClickListener {
                    saveBitmap(viewModel.resultBitmap)
                    popUpWindow?.dismiss()
                }
                closeLayoutButton.setOnClickListener {
                    popUpWindow?.dismiss()
                }
            }
        }
    }

    private fun navigateBackToGamePage() {
        // TODO: Add the direction from result page to game page
        val action = ResultPageFragmentDirections.actionResultPageFragmentToGamePageFragment(
            vocabularySetId = args.vocabularySetId
        )
        val action = ResultPageFragmentDirections.actionResultPageFragmentToGamePageFragment(vocabularySetId = arguments?.getInt("vocabularySetId") ?:0)
        findNavController().navigate(action)
    }

    private fun shareBitmap(bitmap: Bitmap?) {
        if (bitmap == null) return

        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "image/*"
        sharingIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        sharingIntent.putExtra(Intent.EXTRA_STREAM, viewModel.saveImage(bitmap, requireContext()))
        sharingIntent.putExtra(Intent.EXTRA_TEXT, "Game2Mem")
        startActivity(Intent.createChooser(sharingIntent, "Share Image"))
    }

    private fun saveBitmap(bitmap: Bitmap?) {
        if (bitmap == null) return
        val fileHandler = FileHandler()
        val date = Calendar.getInstance()
        val fileName =
            String.format("GameToMem_screenshot_%04d%02d%02d_%02d%02d%02d.jpeg",
                date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH),
                when(date.get(Calendar.AM_PM)){
                    Calendar.AM -> date.get(Calendar.HOUR)
                    else -> date.get(Calendar.HOUR) + 12
                },
                date.get(Calendar.MINUTE), date.get(Calendar.SECOND))

//        Log.d("ResultPageFragment", fileName)
        fileHandler.saveBitmapToExternalDirectory(requireContext(), bitmap, fileName)
        Toast.makeText(context, "Screenshot saved!", Toast.LENGTH_SHORT).show()
    }
}