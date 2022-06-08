package com.example.finalprojecttemplate.ui.setting


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecttemplate.domain.models.AchievementSetModel
import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowDarkModeViewModel @Inject constructor (
    private val useCases: UseCases
): ViewModel() {

//    val Dark:Boolean
//        get() = useCases.getIsDarkMode()
    fun setdarkMode(ischeck: Boolean){
        useCases.setIsDarkModeUseCase(ischeck)
    }
    fun darkMode():Boolean{
        return useCases.getIsDarkMode()
    }
//    private val _DarkMode = MutableLiveData<AchievementSetModel>()
//    val DarkMode : LiveData<AchievementSetModel>
//        get() = _DarkMode
}