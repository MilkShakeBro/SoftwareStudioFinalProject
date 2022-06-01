package com.example.finalprojecttemplate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.TemplateLayoutBinding

class GameTutorialFragment: Fragment()  {

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
                val action = GameTutorialFragmentDirections.actionGameTutorialFragmentToGamePageFragment()
                findNavController().navigate(action)
            }
            button1.text = "Skip"
            fragmentDescription.text = "This is GameTutorialFragment"
        }
    }
}