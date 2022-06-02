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

            /** The following functions are used to test UserInfoDataStore.kt
            testDataStoreButton1.setOnClickListener {
                viewModel.setUserName("!!!")
            }
            testDataStoreButton2.setOnClickListener {
                viewModel.setAmountOfVoc(100)
            }
            testDataStoreButton3.setOnClickListener {
                viewModel.setIsDarkMode(true)
            }*/
        }

        viewModel.apply {
            /** The following functions are used to test UserInfoDataStore.kt
            userNameFlow.observe(viewLifecycleOwner) {
                updateTestText()
            }

            amountOfVoc.observe(viewLifecycleOwner) {
                updateTestText()
            }

            isDarkMode.observe(viewLifecycleOwner) {
                updateTestText()
            }*/
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

/** The following functions are used to test UserInfoDataStore.kt
    private fun updateTestText() {
        binding?.testDataStoreTextView?.text = String.format(
            "UserName: %s\nAmountOfVoc: %d\nDarkMode: %s\n",
            viewModel.userNameFlow.value,
            viewModel.amountOfVoc.value,
            viewModel.isDarkMode.value.toString()
        )
    }*/
}