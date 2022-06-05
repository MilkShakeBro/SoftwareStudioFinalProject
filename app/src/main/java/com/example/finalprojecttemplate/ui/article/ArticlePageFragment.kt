package com.example.finalprojecttemplate.ui.article

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.finalprojecttemplate.R
import com.example.finalprojecttemplate.databinding.ArticleBinding
import com.example.finalprojecttemplate.databinding.ArticlePageBinding
import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.models.ThemeDataModel
import com.example.finalprojecttemplate.ui.game_result.ResultPageFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.article_page.view.*
import kotlinx.android.synthetic.main.game_tutorial_fragment.*
import kotlinx.android.synthetic.main.result_page_screenshot_layout.*

@AndroidEntryPoint
class ArticlePageFragment: Fragment()  {

    private var binding: ArticlePageBinding? = null

    private val showArticleViewModel: ShowArticleViewModel by viewModels()
    private var articleData: ArticleModel?=null
    private var count = 0
    private var i = 0
    private var score_count = 0

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
            count = 0

            showArticleViewModel.onEvent()

            button.setOnClickListener{
                if(count==0)
                {
                    button.text = "OK!"
                    count+=1

                    for ( i in 0 until AnswerOneGroup.childCount-1)
                    {
                        AnswerOneGroup.getChildAt(i).isEnabled = false
                    }
                    for ( i in 0 until AnswerTwoGroup.childCount-1)
                    {
                        AnswerTwoGroup.getChildAt(i).isEnabled = false
                    }
                    for ( i in 0 until AnswerThreeGroup.childCount-1)
                    {
                        AnswerThreeGroup.getChildAt(i).isEnabled = false
                    }
                    for ( i in 0 until AnswerFourGroup.childCount-1)
                    {
                        AnswerFourGroup.getChildAt(i).isEnabled = false
                    }

                    when(AnswerOneGroup.checkedRadioButtonId )
                    {
                        R.id.Answer_one_A->{
                            if(correctOne.text!="A")
                            {
                                correctOne.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_one_B->{
                            if(correctOne.text!="B")
                            {
                                correctOne.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count += 1
                            }
                        }
                        R.id.Answer_one_C->{
                            if(correctOne.text!="C")
                            {
                                correctOne.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_one_D->{
                            if(correctOne.text!="D")
                            {
                                correctOne.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        else->{
                            correctOne.visibility = View.VISIBLE
                        }
                    }

                    when(AnswerTwoGroup.checkedRadioButtonId)
                    {
                        R.id.Answer_two_A->{
                            if(correctTwo.text!="A")
                            {
                                correctTwo.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_two_B->{
                            if(correctTwo.text!="B")
                            {
                                correctTwo.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_two_C->{
                            if(correctTwo.text!="C")
                            {
                                correctTwo.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_two_D-> {
                            if (correctTwo.text != "D") {
                                correctTwo.visibility = View.VISIBLE
                            } else {
                                score_count += 1
                            }
                        }
                        else->{
                            correctTwo.visibility = View.VISIBLE
                        }
                    }

                    when(AnswerThreeGroup.checkedRadioButtonId)
                    {
                        R.id.Answer_three_A->{
                            if(correctThree.text!="A")
                            {
                                correctThree.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_three_B->{
                            if(correctThree.text!="B")
                            {
                                correctThree.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_three_C->{
                            if(correctThree.text!="C")
                            {
                                correctThree.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_three_D->{
                            if(correctThree.text!="D")
                            {
                                correctThree.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        else->{
                            correctThree.visibility = View.VISIBLE
                        }
                    }

                    when(AnswerFourGroup.checkedRadioButtonId)
                    {
                        R.id.Answer_four_A->{
                            if(correctFour.text!="A")
                            {
                                correctFour.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_four_B->{
                            if(correctFour.text!="B")
                            {
                                correctFour.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_four_C->{
                            if(correctFour.text!="C")
                            {
                                correctFour.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        R.id.Answer_four_D->{
                            if(correctFour.text!="D")
                            {
                                correctFour.visibility = View.VISIBLE
                            }
                            else
                            {
                                score_count+=1
                            }
                        }
                        else->{
                            correctFour.visibility = View.VISIBLE
                        }
                    }

                    when(score_count)
                    {
                        0->{
                            Result.text = "0/4"
                        }
                        1->{
                            Result.text = "1/4"
                        }
                        2->{
                            Result.text = "2/4"
                        }
                        3->{
                            Result.text = "3/4"
                        }
                        4->{
                            Result.text = "4/4"
                        }
                        else->{
                            Result.text = "0/4"
                        }
                    }
                    Score.visibility = View.VISIBLE
                    Result.visibility = View.VISIBLE
                }
                else
                {
                    count = 0
                    score_count = 0
                    val action = ArticlePageFragmentDirections.actionArticlePageFragmentToHomePageFragment()
                    findNavController().navigate(action)
                }
            }

        }

        showArticleViewModel.displayArticle.observe(viewLifecycleOwner) { newArticle ->

            articleData=newArticle

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

            binding?.correctOne?.text = newArticle.answer[1]
            binding?.correctTwo?.text = newArticle.answer[2]
            binding?.correctThree?.text = newArticle.answer[3]
            binding?.correctFour?.text = newArticle.answer[4]
        }
    }
}