package com.example.finalprojecttemplate.tetris

import android.content.res.Resources
import androidx.lifecycle.*
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class TetrisGameViewModel(resources: Resources): ViewModel() {
    var tetrisState: TetrisState = TetrisState(resources)

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<ApiStatus> = _status

    private val _words = MutableLiveData<Array<String>>()

    val words: LiveData<Array<String>> = _words

    private val _word = MutableLiveData<String>()

    val word: LiveData<String> = _word

    /**
     * Call getWords() on init so we can display status immediately.
     */
//    init {
//        getWords()
//    }

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
}

class TetrisGameViewModelFactory(private val resources: Resources): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TetrisGameViewModel(resources) as T
    }
}