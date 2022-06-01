package com.example.finalprojecttemplate.ui

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.databinding.FlashcardPageFragmentBinding

class FlashcardPageFragment: Fragment()  {

    //ClockWise
    private lateinit var animatorSetLeftOut: AnimatorSet
    private lateinit var animatorSetRightIn: AnimatorSet
    private var canFlip = true

//    private var flipModel: FlipModel? = null
    private var binding: FlashcardPageFragmentBinding? = null
    private var isBackVisible = false

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

        countdown()
        loadAnimations()
        changeCameraDistance()
        setup()
        binding?.apply {
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
    private fun setup(){
        binding?.cardFront?.setOnClickListener{
            flipClockWise()
        }
        binding?.cardBack?.setOnClickListener{
            flipClockWise()
        }
        binding?.cardBack?.alpha = 0f
        binding?.cardFront?.alpha = 1f
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
            }
        }.start()
    }
    private fun loadAnimations(){
        animatorSetLeftOut = AnimatorInflater.loadAnimator(
            context,
            R.animator.left_out
        ) as AnimatorSet
        animatorSetRightIn = AnimatorInflater.loadAnimator(
            context,
            R.animator.right_in
        ) as AnimatorSet
        animatorSetLeftOut.addListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(animation: Animator?) {
                canFlip = true
            }
            override fun onAnimationCancel(p0: Animator?) {
            }
            override fun onAnimationRepeat(p0: Animator?) {
            }
            override fun onAnimationStart(animation: Animator?) {
                canFlip = false
            }
        })
    }
    private fun changeCameraDistance() {
        val distance = 8000
        val scale = resources.displayMetrics.density * distance
        binding?.cardFront?.cameraDistance = scale
        binding?.cardBack?.cameraDistance = scale
    }
    private fun flipClockWise() {
        if (!canFlip) return

        if (!isBackVisible) {
            animatorSetLeftOut.setTarget(binding?.cardFront)
            animatorSetRightIn.setTarget(binding?.cardBack)
        } else {
            animatorSetLeftOut.setTarget(binding?.cardBack)
            animatorSetRightIn.setTarget(binding?.cardFront)
        }
        animatorSetLeftOut.start()
        animatorSetRightIn.start()
        isBackVisible = !isBackVisible
    }
}
