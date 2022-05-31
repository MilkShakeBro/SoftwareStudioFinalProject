package com.example.finalprojecttemplate.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.ArticleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlePageFragment: Fragment()  {

    private var binding: ArticleBinding? = null

    private val showArticleViewModel: ShowArticleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = ArticleBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            articleContent.text = ""
            randonFetchButton.setOnClickListener {
                showArticleViewModel.onEvent(ShowArticleEvent.OnRandomFetch)
            }
        }

        showArticleViewModel.displayArticle.observe(viewLifecycleOwner) { newArticle ->
            binding?.articleContent?.text = newArticle.content
            binding?.articleId?.text = String.format("Article ID: ${newArticle.id}")
        }
    }
}