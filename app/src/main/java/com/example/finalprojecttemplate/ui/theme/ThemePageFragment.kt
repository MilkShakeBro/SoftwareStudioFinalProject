package com.example.finalprojecttemplate.ui.theme

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.finalprojecttemplate.databinding.ThemeFragmentBinding

class ThemePageFragment: Fragment()  {


    private var binding: ThemeFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = ThemeFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
//            click1.setOnClickListener {
//                val action = ThemePageFragmentDirections.actionThemePageFragmentToHomePageFragment()
//                findNavController().navigate(action)
//            }
        }
    }
}