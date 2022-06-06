package com.example.finalprojecttemplate.ui.flashcard

import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecttemplate.domain.models.VocabularySetModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import com.example.finalprojecttemplate.ui.homepage.DataFetchStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FlashcardPageViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel(){

    var index = 0

    private val _status = MutableLiveData<DataFetchStatus>()
    val status: LiveData<DataFetchStatus>
        get() = _status

    private val _displayedVocabularySet = MutableLiveData<VocabularySetModel>()
    val displayedVocabularySet : LiveData<VocabularySetModel>
        get() = _displayedVocabularySet


//    fun onFetchVocabularySet() {
//        viewModelScope.launch {
//            _displayedVocabularySet.value = useCases.getVocabularySet(index)
//        }
//    }
    fun onFetchVocabularySet(){
        viewModelScope.launch {
            _status.value = DataFetchStatus.LOADING
            try{
                _displayedVocabularySet.value = useCases.getVocabularySet(index)
                _status.value = DataFetchStatus.SUCCESS
            } catch (e: Exception) {
                e.printStackTrace()
                _status.value = DataFetchStatus.ERROR
            }
        }
    }
}