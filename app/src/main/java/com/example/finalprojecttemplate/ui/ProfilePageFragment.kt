package com.example.finalprojecttemplate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.TemplateLayoutBinding

class ProfilePageFragment: Fragment()  {

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
                val action = ProfilePageFragmentDirections.actionProfilePageFragmentToSettingPageFragment()
                findNavController().navigate(action)
            }
            button1.text = "Setting"
            button2.setOnClickListener{
                val action = ProfilePageFragmentDirections.actionProfilePageFragmentToHomePageFragment()
                findNavController().navigate(action)
            }
            button2.text = "Home"
            fragmentDescription.text = "This is ProfilePageFragment"
        }
    }
}