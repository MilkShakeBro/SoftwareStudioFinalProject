package com.example.finalprojecttemplate.ui.game_tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import com.example.finalprojecttemplate.databinding.GameTutorialFragmentBinding
import com.example.finalprojecttemplate.databinding.GameTutorialSlideFragmentBinding
import com.example.finalprojecttemplate.ui.flashcard.FlashcardPageFragmentDirections
import kotlinx.android.synthetic.main.game_tutorial_fragment.*

class GameTutorialFragment: Fragment()  {

    private var binding: GameTutorialSlideFragmentBinding? = null
    private var gameTutorialAdapter: GameTutorialAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = GameTutorialSlideFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: GameTutorialFragmentArgs by navArgs()

        gameTutorialAdapter = GameTutorialAdapter(this.context, args.vocabularySetId)

        binding?.apply {
            viewpager.adapter = gameTutorialAdapter
        }

    }
}