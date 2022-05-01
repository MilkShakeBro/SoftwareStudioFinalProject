package com.example.finalprojecttemplate.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.TemplateLayoutBinding

class HomePageFragment: Fragment()  {

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
                val action = HomePageFragmentDirections.actionHomePageFragmentToArticlePageFragment()
                findNavController().navigate(action)
            }
            button1.text = "To ArticleFragment"

            button2.setOnClickListener {
                val action = HomePageFragmentDirections.actionHomePageFragmentToTimerPageFragment()
                findNavController().navigate(action)
            }
            button2.text = "To TimerFragment"

            button3.setOnClickListener {
                val action = HomePageFragmentDirections.actionHomePageFragmentToThemePageFragment()
                findNavController().navigate(action)
            }
            button3.text = "To ThemeFragment"

            button4.text = "(No)"

            fragmentDescription.text = "This is HomePageFragment"
        }
    }
}