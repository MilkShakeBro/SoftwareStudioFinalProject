package com.example.finalprojecttemplate.ui.flashcard

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.databinding.FlashcardPageFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FlashcardPageFragment: Fragment()  {

    private val viewModel: FlashcardPageViewModel by viewModels()
    private var binding: FlashcardPageFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FlashcardPageFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: FlashcardPageFragmentArgs by navArgs()
        Log.d("args", args.toString())
        countdown()
        binding?.apply {
            flashcard.adapter = viewModel.displayedVocabularySet.value?.vocabularySet?.let {
                FlashcardAdapter(
                    it, requireActivity().supportFragmentManager)
            }
            // click skip buttom to go to game tutorial
            SkipToGame.setOnClickListener{
                val action = FlashcardPageFragmentDirections.actionFlashcardPageFragmentToGameTutorialFragment()
                findNavController().navigate(action)
            }
//            button1.setOnClickListener {
//                val action = FlashcardPageFragmentDirections.actionFlashcardPageFragmentToGameTutorialFragment()
//                findNavController().navigate(action)
//            }
//            button1.text = "Game Tutorial"
//
//            button2.setOnClickListener {
//                val action = FlashcardPageFragmentDirections.actionFlashcardPageFragmentToGamePageFragment()
//                findNavController().navigate(action)
//            }
//            button2.text = "Game"
//            fragmentDescription.text = "This is FlashcardPageFragment"
        }
    }
    private fun countdown(){
        val countDownTimerTextView = binding?.countdownTimer

        object : CountDownTimer(100000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsUntilFinished: Long = millisUntilFinished / 1000
                val seconds = secondsUntilFinished % 60
                val minutesUntilFinished : Long = secondsUntilFinished / 60
                val minutes = minutesUntilFinished % 60
                val hoursUntilFinished : Long = minutesUntilFinished / 60
                val hours = hoursUntilFinished % 60

                countDownTimerTextView?.text = String.format("%02d:%02d:%02d", hours, minutes, seconds)
            }

            override fun onFinish() {
                countDownTimerTextView?.text = "00:00:00"
                val action = FlashcardPageFragmentDirections.actionFlashcardPageFragmentToGameTutorialFragment()
                    findNavController().navigate(action)
            }
        }.start()
    }
}
