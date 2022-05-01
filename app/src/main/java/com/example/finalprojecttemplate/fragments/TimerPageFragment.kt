package com.example.finalprojecttemplate.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.TemplateLayoutBinding

class TimerPageFragment: Fragment() {

    private var binding: TemplateLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = TemplateLayoutBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            button1.setOnClickListener {
                val action = TimerPageFragmentDirections.actionTimerPageFragmentToHomePageFragment()
                findNavController().navigate(action)
            }
            button1.text = "Home"

            button2.setOnClickListener {
                val action = TimerPageFragmentDirections.actionTimerPageFragmentToFlashcardPageFragment()
                findNavController().navigate(action)
            }
            button2.text = "Start"

            button3.setOnClickListener {
                val action = TimerPageFragmentDirections.actionTimerPageFragmentToGameTutorialFragment()
                findNavController().navigate(action)
            }
            button3.text = "Skip to game tutorial"

            button4.setOnClickListener {
                val action = TimerPageFragmentDirections.actionTimerPageFragmentToGamePageFragment()
                findNavController().navigate(action)
            }
            button4.text = "Skip to play game"

            fragmentDescription.text = "This is TimerPageFragment"
        }
    }
}