package com.example.finalprojecttemplate.ui.theme

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.finalprojecttemplate.databinding.ThemeFragmentBinding
import com.example.finalprojecttemplate.domain.models.ThemeDataModel
import com.example.finalprojecttemplate.domain.utils.bindImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.theme_fragment.*

@AndroidEntryPoint
class ThemePageFragment: Fragment()  {


    private var binding: ThemeFragmentBinding? = null
    private val showThemeViewModel: ShowThemeViewModel by viewModels()
    private var themeData: ThemeDataModel?=null

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

            showThemeViewModel.themeindex = arguments?.getInt("themeId") ?: 0

            word.text = "Let’s try to click on something!"
            chinese.text=""
            showThemeViewModel.onEvent()
            click1.setOnClickListener {
                binding?.word?.text = themeData!!.flashcard[0].word
                binding?.chinese?.text = themeData!!.flashcard[0].chinese
            }
            click2.setOnClickListener {
                binding?.word?.text = themeData!!.flashcard[1].word
                binding?.chinese?.text = themeData!!.flashcard[1].chinese
            }
            click3.setOnClickListener {
                binding?.word?.text = themeData!!.flashcard[2].word
                binding?.chinese?.text = themeData!!.flashcard[2].chinese
            }
            click4.setOnClickListener {
                binding?.word?.text = themeData!!.flashcard[3].word
                binding?.chinese?.text = themeData!!.flashcard[3].chinese
            }
            click5.setOnClickListener {
                binding?.word?.text = themeData!!.flashcard[4].word
                binding?.chinese?.text = themeData!!.flashcard[4].chinese
            }
            click6.setOnClickListener {
                binding?.word?.text = themeData!!.flashcard[5].word
                binding?.chinese?.text = themeData!!.flashcard[5].chinese
            }

        }
        showThemeViewModel.displayTheme.observe(viewLifecycleOwner) { newTheme ->
            themeData = newTheme
            bindImage(theme_image, newTheme.image)
  //          theme_image.setImageURI(newTheme.image)
//            binding?.word?.text = newTheme.flashcard
//            binding?.chinese?.text = newTheme.flashcard
        }
    }
}