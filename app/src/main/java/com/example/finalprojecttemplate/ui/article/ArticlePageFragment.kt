package com.example.finalprojecttemplate.ui.article

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.databinding.ArticleBinding
import com.example.finalprojecttemplate.databinding.ArticlePageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.game_tutorial_fragment.*
import kotlinx.android.synthetic.main.result_page_screenshot_layout.*

@AndroidEntryPoint
class ArticlePageFragment: Fragment()  {

    private var binding: ArticlePageBinding? = null

    private val showArticleViewModel: ShowArticleViewModel by viewModels()

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
            showArticleViewModel.themeindex = arguments?.getInt("articleId") ?: 0

            ArticleContent.text = ""
            QuestionOne.text = ""
            QuestionTwo.text = ""
            QuestionThree.text = ""
            QuestionFour.text = ""
            AnswerOneA.text = ""
            AnswerOneB.text = ""
            AnswerOneC.text = ""
            AnswerOneD.text = ""
            AnswerTwoA.text = ""
            AnswerTwoB.text = ""
            AnswerTwoC.text = ""
            AnswerTwoD.text = ""
            AnswerThreeA.text = ""
            AnswerThreeB.text = ""
            AnswerThreeC.text = ""
            AnswerThreeD.text = ""
            AnswerFourA.text = ""
            AnswerFourB.text = ""
            AnswerFourC.text = ""
            AnswerFourD.text = ""

            showArticleViewModel.onEvent()

        }

        showArticleViewModel.displayArticle.observe(viewLifecycleOwner) { newArticle ->
            binding?.ArticleContent?.text = newArticle.content
            binding?.QuestionOne?.text = newArticle.question[1]?.get(0)
            binding?.QuestionTwo?.text = newArticle.question[2]?.get(0)
            binding?.QuestionThree?.text = newArticle.question[3]?.get(0)
            binding?.QuestionFour?.text = newArticle.question[4]?.get(0)

            binding?.AnswerOneA?.text = newArticle.question[1]?.get(1)
            binding?.AnswerOneB?.text = newArticle.question[1]?.get(2)
            binding?.AnswerOneC?.text = newArticle.question[1]?.get(3)
            binding?.AnswerOneD?.text = newArticle.question[1]?.get(4)

            binding?.AnswerTwoA?.text = newArticle.question[2]?.get(1)
            binding?.AnswerTwoB?.text = newArticle.question[2]?.get(2)
            binding?.AnswerTwoC?.text = newArticle.question[2]?.get(3)
            binding?.AnswerTwoD?.text = newArticle.question[2]?.get(4)

            binding?.AnswerThreeA?.text = newArticle.question[3]?.get(1)
            binding?.AnswerThreeB?.text = newArticle.question[3]?.get(2)
            binding?.AnswerThreeC?.text = newArticle.question[3]?.get(3)
            binding?.AnswerThreeD?.text = newArticle.question[3]?.get(4)

            binding?.AnswerFourA?.text = newArticle.question[4]?.get(1)
            binding?.AnswerFourB?.text = newArticle.question[4]?.get(2)
            binding?.AnswerFourC?.text = newArticle.question[4]?.get(3)
            binding?.AnswerFourD?.text = newArticle.question[4]?.get(4)
        }
    }
}