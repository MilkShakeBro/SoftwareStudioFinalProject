package com.example.finalprojecttemplate.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.ArticlePageBinding
import com.example.finalprojecttemplate.databinding.TemplateLayoutBinding

class ArticlePageFragment: Fragment()  {

    private var binding: ArticlePageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = ArticlePageBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            button.setOnClickListener {
                val action = ArticlePageFragmentDirections.actionArticlePageFragmentToHomePageFragment()
                findNavController().navigate(action)
            }
        }
    }
}