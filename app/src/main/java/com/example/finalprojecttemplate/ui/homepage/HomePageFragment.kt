package com.example.finalprojecttemplate.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.HomePageFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment: Fragment()  {

    private var binding: HomePageFragmentBinding? = null

//    private lateinit var fakeDataSource: HomePageTestData

    private val viewModel: HomePageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = HomePageFragmentBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        fakeDataSource = HomePageTestData(resources)

        val articleAdapter = HomePageListAdapter { id ->
            goToArticlePage()
        }

        val vocabularyAdapter = HomePageListAdapter { id ->
            goToVocabularyPage()
        }

        val themeAdapter = HomePageListAdapter { id ->
            goToThemePage()
        }

//        articleAdapter.submitList(fakeDataSource.articlesTestCases)
//        vocabularyAdapter.submitList(fakeDataSource.vocabulariesTestCases)
//        themeAdapter.submitList(fakeDataSource.themeTestCases)

        articleAdapter.submitList(viewModel.homePageArticlesInfo)
        vocabularyAdapter.submitList(viewModel.homePageVocabularySetInfo)
        themeAdapter.submitList(viewModel.homePageThemeInfo)


        binding?.apply {
            readingArticleRecyclerView.adapter = articleAdapter
            vocabulariesSetsListRecyclerView.adapter = vocabularyAdapter
            themeListRecyclerView.adapter = themeAdapter
        }
    }

    private fun goToArticlePage() {
        val action = HomePageFragmentDirections.actionHomePageFragmentToArticlePageFragment()
        findNavController().navigate(action)
    }

    private fun goToVocabularyPage() {
        val action = HomePageFragmentDirections.actionHomePageFragmentToTimerPageFragment()
        findNavController().navigate(action)
    }

    private fun goToThemePage() {
        val action = HomePageFragmentDirections.actionHomePageFragmentToThemePageFragment()
        findNavController().navigate(action)
    }
}