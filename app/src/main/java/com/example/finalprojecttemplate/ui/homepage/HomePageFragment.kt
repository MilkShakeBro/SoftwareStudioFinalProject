package com.example.finalprojecttemplate.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.HomePageFragmentBinding
import com.example.finalprojecttemplate.domain.models.showInString
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
            goToArticlePage(id)
        }

        val vocabularyAdapter = HomePageListAdapter { id ->
            goToVocabularyPage(id)
        }

        val themeAdapter = HomePageListAdapter { id ->
            goToThemePage(id)
        }

//        articleAdapter.submitList(fakeDataSource.articlesTestCases)
//        vocabularyAdapter.submitList(fakeDataSource.vocabulariesTestCases)
//        themeAdapter.submitList(fakeDataSource.themeTestCases)

        binding?.apply {
            readingArticleRecyclerView.adapter = articleAdapter
            vocabulariesSetsListRecyclerView.adapter = vocabularyAdapter
            themeListRecyclerView.adapter = themeAdapter

            binding?.loadingAndErrorLayout?.visibility = View.VISIBLE
            binding?.loadingProgressBar?.visibility = View.VISIBLE
            binding?.errorMessageTextView?.visibility = View.GONE


            /** The following operation is used to test LocalDatabase.kt
            forTestLocalDatabaseUseButton.setOnClickListener {
                viewModel.addAchievement()
            } */

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
            fetchHomepageInfo()

            status.observe(viewLifecycleOwner) { newStatus ->
                when(newStatus) {
                    DataFetchStatus.SUCCESS -> {
                        articleAdapter.submitList(viewModel.homePageArticlesInfo)
                        vocabularyAdapter.submitList(viewModel.homePageVocabularySetInfo)
                        themeAdapter.submitList(viewModel.homePageThemeInfo)
                        binding?.loadingAndErrorLayout?.visibility = View.GONE
                    }
                    DataFetchStatus.ERROR -> {
                        binding?.loadingAndErrorLayout?.visibility = View.VISIBLE
                        binding?.errorMessageTextView?.visibility = View.VISIBLE
                        binding?.loadingProgressBar?.visibility = View.GONE
                    }
                    DataFetchStatus.LOADING -> {
                        binding?.loadingAndErrorLayout?.visibility = View.VISIBLE
                        binding?.loadingProgressBar?.visibility = View.VISIBLE
                        binding?.errorMessageTextView?.visibility = View.GONE
                    }
                    else -> {

                    }
                }
            }

            /** The following operations are used to test LocalDatabase.kt
            achievementsFlow.observe(viewLifecycleOwner) { newList ->
                var showString = ""
                newList.forEach { achievement ->
                    showString += achievement.showInString()
                }
                binding?.forTestLocalDatabaseUseTextView?.text = showString
            } */

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

    private fun goToArticlePage(id: Int) {
        val action = HomePageFragmentDirections.actionHomePageFragmentToArticlePageFragment(
            articleId = id
        )
        findNavController().navigate(action)
    }

    private fun goToVocabularyPage(id: Int) {
        val action = HomePageFragmentDirections.actionHomePageFragmentToTimerPageFragment(
            vocabularySetId = id
        )
        findNavController().navigate(action)
    }

    private fun goToThemePage(id: Int) {
        val action = HomePageFragmentDirections.actionHomePageFragmentToThemePageFragment(
            themeId = id
        )
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