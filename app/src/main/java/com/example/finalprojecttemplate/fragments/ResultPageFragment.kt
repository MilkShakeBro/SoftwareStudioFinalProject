package com.example.finalprojecttemplate.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.finalprojecttemplate.ResultPageViewModel
import com.example.finalprojecttemplate.databinding.ResultPageFragmentBinding
import com.example.finalprojecttemplate.databinding.ResultPageScreenshotLayoutBinding


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

            }

            screenshotButton.setOnClickListener {
                screenshotCheckWindowLayout.visibility = View.VISIBLE
                screenshotImage.setImageBitmap(viewModel.getLayoutScreenShot(resources.displayMetrics.density))
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
}