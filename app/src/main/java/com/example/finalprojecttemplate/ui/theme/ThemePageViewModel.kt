package com.example.finalprojecttemplate.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import com.example.finalprojecttemplate.ui.article.ShowArticleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowArticleViewModel @Inject constructor (
    private val useCases: UseCases
): ViewModel() {

    private val _displayedArticle = MutableLiveData<ArticleModel>()
    val displayArticle : LiveData<ArticleModel>
        get() = _displayedArticle

    private fun onFetchRandomArticle() {
        val randomInt = (0..4).random()
        _displayedArticle.value = useCases.getArticleUseCase(randomInt)
    }

    fun onEvent(event: ShowArticleEvent) {
        when (event) {
            ShowArticleEvent.OnRandomFetch -> {
                onFetchRandomArticle()
            }
        }
    }
}