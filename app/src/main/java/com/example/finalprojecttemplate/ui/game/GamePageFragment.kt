package com.example.finalprojecttemplate.ui.game

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.databinding.GamePageFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GamePageFragment: Fragment()  {

    private var binding : GamePageFragmentBinding? = null

//    private val tetrisGameViewModel: TetrisGameViewModel by viewModels {
//        TetrisGameViewModelFactory(resources)
//    }

    private val tetrisGameViewModel: TetrisGameViewModel by viewModels()

//    private lateinit var tetrisState : TetrisState

    private lateinit var handler: Handler

    private lateinit var loop: Runnable

    private lateinit var gradientDrawable: GradientDrawable

    private lateinit var fadeAwayObjectAnimator: AnimatorSet

    private lateinit var moveUpObjectAnimator: AnimatorSet

    private var theta = 0f

    private var countDownSecondCount = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = GamePageFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

//        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        activity?.actionBar?.hide()

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gradientDrawable = ResourcesCompat.getDrawable(
            resources,
            R.drawable.tetris_background_gradient, null) as GradientDrawable

        fadeAwayObjectAnimator = AnimatorInflater.loadAnimator(
            context,
            R.animator.gradually_fade_animator
        ) as AnimatorSet

        moveUpObjectAnimator = AnimatorInflater.loadAnimator(
            context,
            R.animator.gradually_move_up_animator
        ) as AnimatorSet

        binding?.apply {
//            tetrisView.fontFamily = ResourcesCompat.getFont(requireContext(), R.font.oxygen_bold)
            tetrisView.fontFamily = Typeface.DEFAULT_BOLD

            tetrisView.setTetrisState(tetrisGameViewModel.tetrisState)

            tetrisView.setOnMatchWord {
                moveUpAndDisappearInMillisecond(matchMessage, 1000)
            }


            leftButton.setOnClickListener {
//                tetrisView.tetraminoGoDir(Direction.LEFT)
                tetrisView.tetraminoGoLeftMost()
            }
            downButton.setOnClickListener {
                tetrisView.tetraminoGoDir(Direction.DOWN)

            }
            upButton.setOnClickListener {
                tetrisView.tetraminoGoDir(Direction.UP)
            }

            showAndDisappearInMillisecond(countdownMessage, 1000)

            handler = Handler(Looper.getMainLooper())
            loop = object: Runnable {
                override fun run() {
                    /* 20220507, Change the period time of updating. Consider the execution time and fluent */
                    handler.postDelayed(this, 20)
//                    tetrisView.update(scoreNumberTextView)
                    tetrisView.update()
                    chineseExplanation.text = tetrisView.getChineseMeaning().toString()

                    if (theta >= 2 * Math.PI) theta = 0f
                    else theta += 0.0157f

                    gradientDrawable.setGradientCenter(
                        0.5f + 0.5f * kotlin.math.cos(theta.toDouble()).toFloat(),
                        0.5f + 0.5f * kotlin.math.sin(theta.toDouble()).toFloat()
                    )

                    tetrisConstraintLayout.background = gradientDrawable

                    when (countDownSecondCount) {
                        50 -> {
                            countdownMessage.text = "2"
                            showAndDisappearInMillisecond(countdownMessage, 1000)
                        }
                        100 -> {
                            countdownMessage.text = "1"
                            showAndDisappearInMillisecond(countdownMessage, 1000)
                        }
                        150 -> {
                            countdownMessage.visibility = View.GONE
                            countdownMessageConstraintLayout.visibility = View.GONE
                            tetrisView.tetrisGameState?.startGame()
                        }
                    }
                    if (countDownSecondCount <= 150) countDownSecondCount += 1
                }
            }
            tetrisGameViewModel.tetrisState.score.observe(viewLifecycleOwner) { newScore ->
                scoreNumberTextView.text = newScore.toString()
            }
            tetrisGameViewModel.tetrisState.gameState.observe(viewLifecycleOwner) { newState ->
                if (newState == GameState.END) goToResultPage()
            }
            skipButton.setOnClickListener {
                goToResultPage()
            }
            handler.post(loop)
        }
    }

    override fun onDestroyView() {
        handler.removeCallbacks(loop)
        super.onDestroyView()
    }

    fun goToResultPage() {
        // TODO: add argument to result page in nav graph
        val action = GamePageFragmentDirections.actionGamePageFragmentToResultPageFragment(
            score = tetrisGameViewModel.tetrisState.score.value!!
        )
//        val action = GamePageFragmentDirections.actionGamePageFragmentToResultPageFragment()
        findNavController().navigate(action)
    }

    private fun showAndDisappearInMillisecond(view: View, millisecond: Long) {
        view.visibility = View.VISIBLE
        view.alpha = 1f

        fadeAwayObjectAnimator.setTarget(view)

        fadeAwayObjectAnimator.start()

        Handler(Looper.getMainLooper()).postDelayed(millisecond) {
            view.visibility = View.GONE
        }
    }

    private fun moveUpAndDisappearInMillisecond(view: View, millisecond: Long) {
        view.visibility = View.VISIBLE
        view.alpha = 1f

        moveUpObjectAnimator.setTarget(view)

        moveUpObjectAnimator.start()

        Handler(Looper.getMainLooper()).postDelayed(millisecond) {
            view.visibility = View.GONE
        }
    }
}