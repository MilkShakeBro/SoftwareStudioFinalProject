package com.example.finalprojecttemplate.ui.flashcard

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
import com.example.finalprojecttemplate.databinding.FlashcardFragmentBinding
import com.example.finalprojecttemplate.databinding.FlashcardPageFragmentBinding
import com.example.finalprojecttemplate.domain.models.Vocabulary
import com.example.finalprojecttemplate.domain.models.VocabularySetModel
import kotlinx.android.synthetic.main.flashcard_fragment.*

class FlashcardFragment : Fragment(){
    //ClockWise
    private lateinit var animatorSetLeftOut: AnimatorSet
    private lateinit var animatorSetRightIn: AnimatorSet
    private var canFlip = true

    private var flipModel: Vocabulary? = null
    private var binding: FlashcardFragmentBinding? = null
    private var isBackVisible = false

    companion object {
        const val FLIP_MODEL_KEY = "FLIP_MODEL_KEY"
        fun getDefaultBundle(flipModel: Vocabulary): Bundle = Bundle().apply {
            putSerializable(
                FLIP_MODEL_KEY,
                flipModel
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FlashcardFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flipModel = arguments?.getSerializable(FLIP_MODEL_KEY) as Vocabulary?
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
        binding?.apply {
            //tvTitle.text = flipModel?.id.toString()
            tvContent.text = flipModel?.word
            tvContentBack.text = flipModel?.chinese
            cardFront.setOnClickListener {
                flipClockWise()
            }
            cardBack.setOnClickListener {
                flipClockWise()
            }
            /*if(flipModel?.isFlipped == true){
                cardBack.alpha = 1f
                cardFront.alpha = 0f
            }else{
                cardBack.alpha = 0f
                cardFront.alpha = 1f
            }*/
            cardBack.alpha = 0f
            cardFront.alpha = 1f
        }
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
