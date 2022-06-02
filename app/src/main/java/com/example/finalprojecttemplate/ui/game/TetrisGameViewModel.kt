package com.example.finalprojecttemplate.ui.game

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.*
import com.example.finalprojecttemplate.domain.models.Vocabulary
import com.example.finalprojecttemplate.domain.models.VocabularySetModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ApiStatus { LOADING, ERROR, DONE }

@HiltViewModel
class TetrisGameViewModel @Inject constructor(
    private val useCases: UseCases
): ViewModel() {

    lateinit var tetrisState: TetrisState

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<ApiStatus> = _status

    private val _words = MutableLiveData<Array<String>>()

    val words: LiveData<Array<String>> = _words

    private val _word = MutableLiveData<String>()

    val word: LiveData<String> = _word

    private var tetrisVocabularySet : VocabularySetModel? = null

    /**
     * Call getWords() on init so we can display status immediately.
     */
    init {
        submitWordsToTetrisState()
    }

//    private fun getWords() {
//        viewModelScope.launch {
//            _status.value = ApiStatus.LOADING
//            try {
//                _words.value = WordsApi.retrofitService.getWords()
//                _status.value = ApiStatus.DONE
//            } catch (e: Exception) {
//                _words.value = Array<String>(9){it -> it.toString()}
//                _status.value = ApiStatus.ERROR
//            }
//        }
//    }

    private fun getWord() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
//                _word.value = WordsApi.retrofitService.getWord()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _word.value = "N/A"
                _status.value = ApiStatus.ERROR
            }
        }
    }

    private fun submitWordsToTetrisState() {
        val randomInt = (0..4).random()

        tetrisVocabularySet = useCases.getVocabularySet(randomInt)

        val vocabularyArray = tetrisVocabularySet!!.vocabularySet.map {
            it.toTetrisVocabulary()
        }.toTypedArray()

        tetrisState = TetrisState(vocabularyArray)

        GameConstant.VOCABULARY_COUNT = vocabularyArray.size

        var count = 0
        for (item in vocabularyArray) {
            if (item.suffixRow == "ce") count++
        }
        Log.d("TetrisGameViewModel", "suffix count is $count")
    }
}

//class TetrisGameViewModelFactory(private val resources: Resources): ViewModelProvider.Factory {
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return TetrisGameViewModel() as T
//    }
//}