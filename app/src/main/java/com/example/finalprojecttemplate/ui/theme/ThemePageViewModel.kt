package com.example.finalprojecttemplate.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.models.ThemeDataModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import com.example.finalprojecttemplate.ui.article.ShowArticleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.finalprojecttemplate.ui.homepage.HomePageViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class ShowThemeViewModel @Inject constructor (
    private val useCases: UseCases
): ViewModel() {

    private val _displayedTheme = MutableLiveData<ThemeDataModel>()
    val displayTheme : LiveData<ThemeDataModel>
        get() = _displayedTheme

    fun onEvent() {
        viewModelScope.launch{
            _displayedTheme.value = useCases.getThemeData(0)
        }
    }
}