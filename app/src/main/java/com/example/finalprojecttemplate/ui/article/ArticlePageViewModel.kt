package com.example.finalprojecttemplate.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowArticleViewModel @Inject constructor (
    private val useCases: UseCases
): ViewModel() {

    var articleindex = 0
    private val _displayedArticle = MutableLiveData<ArticleModel>()
    val displayArticle : LiveData<ArticleModel>
        get() = _displayedArticle

    fun onEvent() {
        viewModelScope.launch {
            _displayedArticle.value = useCases.getArticleUseCase(articleindex)
        }
    }
}