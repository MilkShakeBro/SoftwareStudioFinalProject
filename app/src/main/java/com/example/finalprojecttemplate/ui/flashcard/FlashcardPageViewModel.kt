package com.example.finalprojecttemplate.ui.flashcard

import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalprojecttemplate.domain.models.VocabularySetModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FlashcardPageViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel(){
    private val _displayedVocabularySet = MutableLiveData<VocabularySetModel>()
    val displayedVocabularySet : LiveData<VocabularySetModel>
        get() =
            if(_displayedVocabularySet.value == null) {
                onFetchVocabularySet()
                _displayedVocabularySet
            }
            else _displayedVocabularySet

    private fun onFetchVocabularySet() {
        val randomInt = (0..4).random()
        _displayedVocabularySet.value = VocabularySetModel(0, "", "".toUri(), listOf()) //useCases.getVocabularySet(randomInt)
    }
}