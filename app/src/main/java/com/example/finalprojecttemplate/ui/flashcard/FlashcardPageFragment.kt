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
import com.example.finalprojecttemplate.domain.models.VocabularySetModel
import com.example.finalprojecttemplate.ui.homepage.DataFetchStatus
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.flashcard_page_fragment.*
import kotlin.properties.Delegates

@AndroidEntryPoint
class FlashcardPageFragment: Fragment()  {

    private val viewModel: FlashcardPageViewModel by viewModels()
    private var binding: FlashcardPageFragmentBinding? = null
    private val args: FlashcardPageFragmentArgs by navArgs()
    private var vocabularyset: VocabularySetModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FlashcardPageFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    //@SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("args", args.toString())

        viewModel.apply {
            index = arguments?.getInt("vocabularySetId") ?:0
            onFetchVocabularySet()
            status.observe(viewLifecycleOwner){ newStatus ->
                when(newStatus){
                    DataFetchStatus.SUCCESS -> {
                        flashcard.adapter = viewModel.displayedVocabularySet.value?.vocabularySet?.let {
                            FlashcardAdapter(
                                it, requireActivity().supportFragmentManager)
                        }
                    }
                    DataFetchStatus.ERROR -> {
//                        binding?.loadingAndErrorLayout?.visibility = View.VISIBLE
//                        binding?.errorMessageTextView?.visibility = View.VISIBLE
//                        binding?.loadingProgressBar?.visibility = View.GONE
                    }
                    DataFetchStatus.LOADING -> {
//                        binding?.loadingAndErrorLayout?.visibility = View.VISIBLE
//                        binding?.errorMessageTextView?.visibility = View.VISIBLE
//                        binding?.loadingProgressBar?.visibility = View.GONE
                    }
                }

            }
        }
//        viewModel.index = arguments?.getInt("vocabularySetId") ?:0
//        viewModel.onFetchVocabularySet()

        val hour = arguments?.getInt("Hour") ?:1
        val min = arguments?.getInt("Minute") ?:0
        val sec = arguments?.getInt("Second") ?:0
        val time: Long = ((hour.times(3600) + min*60 + sec).times(1000)).toLong() ?: 0
        countdown(time)
        binding?.apply {

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
    private fun countdown(Time: Long){
        val countDownTimerTextView = binding?.countdownTimer
        object : CountDownTimer(Time, 1000) {
            override fun onTick(Time: Long) {
                val secondsUntilFinished: Long = Time / 1000
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
