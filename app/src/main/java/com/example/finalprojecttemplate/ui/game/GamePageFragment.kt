package com.example.finalprojecttemplate.ui.game

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.databinding.GamePageFragmentBinding
import com.example.finalprojecttemplate.ui.homepage.DataFetchStatus
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CompletableJob
import java.util.concurrent.TimeUnit

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
    private lateinit var backgroundAnimationLoop: Runnable

    private lateinit var gradientDrawable: GradientDrawable
    private lateinit var fadeAwayObjectAnimator: AnimatorSet
    private lateinit var moveUpObjectAnimator: AnimatorSet

    private var theta = 0f

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

//            tetrisView.setTetrisState(tetrisGameViewModel.tetrisState)

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

            startGameLoop()

            tetrisGameViewModel.submitWordsToTetrisState()

//            handler = Handler(Looper.getMainLooper())
//            loop = object: Runnable {
//                override fun run() {
//                    /* 20220507, Change the period time of updating. Consider the execution time and fluent */
//                    handler.postDelayed(this, 20)
////                    tetrisView.update(scoreNumberTextView)
//                    tetrisView.update()
//                    chineseExplanation.text = tetrisView.getChineseMeaning().toString()
//
//                    if (theta >= 2 * Math.PI) theta = 0f
//                    else theta += 0.0157f
//
//                    gradientDrawable.setGradientCenter(
//                        0.5f + 0.5f * kotlin.math.cos(theta.toDouble()).toFloat(),
//                        0.5f + 0.5f * kotlin.math.sin(theta.toDouble()).toFloat()
//                    )
//
//                    tetrisConstraintLayout.background = gradientDrawable
//
//                    when (countDownSecondCount) {
//                        50 -> {
//                            countdownMessage.text = "2"
//                            showAndDisappearInMillisecond(countdownMessage, 1000)
//                        }
//                        100 -> {
//                            countdownMessage.text = "1"
//                            showAndDisappearInMillisecond(countdownMessage, 1000)
//                        }
//                        150 -> {
//                            countdownMessage.visibility = View.GONE
//                            countdownMessageConstraintLayout.visibility = View.GONE
//                            tetrisView.tetrisGameState?.startGame()
//                        }
//                    }
//                    if (countDownSecondCount <= 150) countDownSecondCount += 1
//                }
//            }
//            tetrisGameViewModel.tetrisState.score.observe(viewLifecycleOwner) { newScore ->
//                scoreNumberTextView.text = newScore.toString()
//            }
//            tetrisGameViewModel.tetrisState.gameState.observe(viewLifecycleOwner) { newState ->
//                if (newState == GameState.END) goToResultPage()
//            }
            skipButton.setOnClickListener {
                goToResultPage()
            }
//            handler.post(loop)
        }

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                tetrisGameViewModel.tetrisState.pauseGame()

                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Are you sure to leave game?")
                    .setMessage("")
                    .setCancelable(false)
                    .setPositiveButton("Cancel") { _, _ ->
                        tetrisGameViewModel.tetrisState.startGame()
                    }
                    .setNegativeButton("Yes") { _, _ ->
                        goBackToHomePage()
                    }
                    .show()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback)
    }

    override fun onDestroyView() {
        endLoops()
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

    private fun goBackToHomePage() {
        val action = GamePageFragmentDirections.actionGamePageFragmentToHomePageFragment()
        findNavController().navigate(action)
    }

    private fun showAndDisappearInMillisecond(view: View, millisecond: Long) {
        fadeAwayObjectAnimator.end()

        view.visibility = View.VISIBLE
        view.alpha = 1f

        fadeAwayObjectAnimator.setTarget(view)

        fadeAwayObjectAnimator.start()

//        handler.postDelayed(millisecond) {
//            view.visibility = View.GONE
//        }
    }

    private fun moveUpAndDisappearInMillisecond(view: View, millisecond: Long) {
        moveUpObjectAnimator.end()

        view.visibility = View.VISIBLE
        view.alpha = 1f

        moveUpObjectAnimator.setTarget(view)

        moveUpObjectAnimator.start()

//        handler.postDelayed(millisecond) {
//            view.visibility = View.GONE
//        }
    }

    private fun startGameLoop() {
        handler = Handler(Looper.getMainLooper())
        loop = object: Runnable {
            override fun run() {
                /* 20220507, Change the period time of updating. Consider the execution time and fluent */
                handler.postDelayed(this, 20)
                binding?.apply {
                    when (tetrisGameViewModel.status.value) {
                        DataFetchStatus.SUCCESS -> {
                            if (tetrisGameViewModel.previousStatus == DataFetchStatus.LOADING) {
                                initializeGame()
                            }
                            tetrisView.update()
                            chineseExplanation.text = tetrisView.getChineseMeaning().toString()
                            progressBarErrorMsgLayout.visibility = View.GONE
                            countdownMessage.visibility = View.VISIBLE
                        }
                        DataFetchStatus.ERROR -> {
                            countdownMessage.visibility = View.GONE
                            progressBarErrorMsgLayout.visibility = View.VISIBLE
                            errorMessageTextView.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                        }
                        DataFetchStatus.LOADING -> {
                            countdownMessage.visibility = View.GONE
                            progressBarErrorMsgLayout.visibility = View.VISIBLE
                            errorMessageTextView.visibility = View.GONE
                            progressBar.visibility = View.VISIBLE
                        }
                        else -> {}
                    }
                }
                tetrisGameViewModel.previousStatus = tetrisGameViewModel.status.value ?: DataFetchStatus.SUCCESS
            }
        }
        handler.post(loop)
    }

    private fun endLoops() {
        handler.removeCallbacks(loop)
        handler.removeCallbacks(backgroundAnimationLoop)
    }

    private fun initializeGame() {
        binding?.apply {
            startCountDown(countdownMessage, countdownMessageConstraintLayout, tetrisView)
            startBackgroundAnimation(tetrisConstraintLayout)
            tetrisView.tetrisGameState = tetrisGameViewModel.tetrisState
            tetrisView.setOnMatchWord {
                moveUpAndDisappearInMillisecond(matchMessage, 1000)
            }
            tetrisGameViewModel.tetrisState.score.observe(viewLifecycleOwner) { newScore ->
                scoreNumberTextView.text = newScore.toString()
            }
            tetrisGameViewModel.tetrisState.gameState.observe(viewLifecycleOwner) { newState ->
                if (newState == GameState.END) goToResultPage()
            }
        }
    }

    private fun startCountDown(
        countdownMessage: TextView,
        countdownMessageConstraintLayout: ConstraintLayout,
        tetrisView: TetrisView
    ) {
        val loop = object: Runnable {
            override fun run() {
                val secondLeft = countdownMessage.text.toString().toInt()

                if (secondLeft >= 2) {
                    countdownMessage.text = (secondLeft - 1).toString()
                    showAndDisappearInMillisecond(countdownMessage, 1000)
                    Log.d("GamePageFragment", "Second Left: ${countdownMessage.text}")
                    handler.postDelayed(this, 1000)
                } else {
                    countdownMessage.visibility = View.GONE
                    countdownMessageConstraintLayout.visibility = View.GONE
                    tetrisView.tetrisGameState?.startGame()
                }
            }
        }
        showAndDisappearInMillisecond(countdownMessage, 1000)
        handler.postDelayed(loop, 1000)
    }

    private fun startBackgroundAnimation(tetrisConstraintLayout: ConstraintLayout) {
        backgroundAnimationLoop = object : Runnable {
            override fun run() {
                if (theta >= 2 * Math.PI) theta = 0f
                else theta += 0.0157f

                gradientDrawable.setGradientCenter(
                    0.5f + 0.5f * kotlin.math.cos(theta.toDouble()).toFloat(),
                    0.5f + 0.5f * kotlin.math.sin(theta.toDouble()).toFloat()
                )

                tetrisConstraintLayout.background = gradientDrawable

                handler.postDelayed(this, 20)
            }
        }
        handler.post(backgroundAnimationLoop)
    }
}