package com.example.finalprojecttemplate.ui.flashcard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.finalprojecttemplate.domain.models.Vocabulary
import com.example.finalprojecttemplate.ui.flashcard.FlipModel

class FlashcardAdapter(
    private val flipModelList: List<Vocabulary>,
    fragmentManger: FragmentManager
) : FragmentStatePagerAdapter(fragmentManger) {

    override fun getItem(position: Int): Fragment = FlashcardFragment().apply {
        arguments = FlashcardFragment.getDefaultBundle(flipModelList[position])
    }

    override fun getCount(): Int = flipModelList.size
}