package com.example.finalprojecttemplate.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.GamePageFragmentBinding
import com.example.finalprojecttemplate.databinding.TemplateLayoutBinding
import com.example.finalprojecttemplate.tetris.Direction
import com.example.finalprojecttemplate.tetris.GameState
import com.example.finalprojecttemplate.tetris.TetrisGameViewModel
import com.example.finalprojecttemplate.tetris.TetrisGameViewModelFactory

class GamePageFragment: Fragment()  {

    private var binding : GamePageFragmentBinding? = null

    private val tetrisGameViewModel: TetrisGameViewModel by viewModels {
        TetrisGameViewModelFactory(resources)
    }

//    private lateinit var tetrisState : TetrisState

    private lateinit var handler: Handler

    private lateinit var loop: Runnable

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = GamePageFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding

        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        activity?.actionBar?.hide()

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
//            tetrisView.fontFamily = ResourcesCompat.getFont(requireContext(), R.font.oxygen_bold)
            tetrisView.fontFamily = Typeface.DEFAULT_BOLD
            tetrisView.setTetrisState(tetrisGameViewModel.tetrisState)
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

            handler = Handler(Looper.getMainLooper())
            loop = object: Runnable {
                override fun run() {
                    /* 20220507, Change the period time of updating. Consider the execution time and fluent */
                    handler.postDelayed(this, 20)
//                    tetrisView.update(scoreNumberTextView)
                    tetrisView.update()
                    chineseExplanation.text = tetrisView.getChineseMeaning().toString()
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
//        val action = GamePageFragmentDirections.actionGamePageFragmentToResultPageFragment(
//            score = tetrisGameViewModel.tetrisState.score.value!!
//        )
        val action = GamePageFragmentDirections.actionGamePageFragmentToResultPageFragment()
        findNavController().navigate(action)
    }
}