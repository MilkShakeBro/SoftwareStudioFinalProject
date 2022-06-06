package com.example.finalprojecttemplate.ui.homepage

import android.util.Log
import android.widget.TextView
import androidx.core.net.toUri
import androidx.lifecycle.*
import com.example.finalprojecttemplate.domain.models.*
import com.example.finalprojecttemplate.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.atan

@HiltViewModel
class HomePageViewModel @Inject constructor (
    private val useCases: UseCases
): ViewModel() {

    private val _homePageInfo = MutableLiveData<HomePageInfoModel>()
    val homePageInfo: LiveData<HomePageInfoModel>
        get() = _homePageInfo
//            if(_homePageInfo.value == null) {
//                _homePageInfo.value = useCases.getHomePageInfo(0)
//                _homePageInfo
//            } else {
//                _homePageInfo
//            }

    private val _status = MutableLiveData<DataFetchStatus>()
    val status: LiveData<DataFetchStatus>
        get() = _status

    val homePageArticlesInfo: List<HomePageInfo>
        get() = homePageInfo.value!!.articleInfo

    val homePageVocabularySetInfo : List<HomePageInfo>
        get() = homePageInfo.value!!.vocabularySetInfo

    val homePageThemeInfo: List<HomePageInfo>
        get() = homePageInfo.value!!.themeInfo

    fun fetchHomepageInfo() {
        viewModelScope.launch {
            _status.value = DataFetchStatus.LOADING
            try {
                _homePageInfo.value = useCases.getHomePageInfo(0)
                _status.value = DataFetchStatus.SUCCESS
            } catch (e: Exception) {
                e.printStackTrace()
                _status.value = DataFetchStatus.ERROR
            }
        }
    }

    var articleModel = MutableLiveData<ArticleModel>()

    fun fetchArticle() {
        val randomId = (0..4).random()
        Log.d("HomePageViewModel", "$randomId")

        viewModelScope.launch {
            articleModel.value = useCases.getArticleUseCase(randomId)
        }
    }

    var vocabularySetModel = MutableLiveData<VocabularySetModel>()

    fun fetchVocabularySet() {
        val randomId = (0..4).random()
        Log.d("HomePageViewModel", "$randomId")

        viewModelScope.launch {
            vocabularySetModel.value = useCases.getVocabularySet(randomId)
        }
    }

    var themeDataModel = MutableLiveData<ThemeDataModel>()

    fun fetchThemeData() {
        val randomId = (0..4).random()
        Log.d("HomePageViewModel", "$randomId")

        viewModelScope.launch {
            themeDataModel.value = useCases.getThemeData(randomId)
        }
    }

    /** The following functions and variables are used too test LocalDatabase.kt
    val achievementsFlow = useCases.getAllAchievementsUseCase().asLiveData()

    fun addAchievement() {
        viewModelScope.launch {
            val achievement = Achievement(
                img = "https://google.com".toUri(),
                description = "HAHAHA",
                obtained = false
            )
            useCases.addAchievementUseCase(achievement)
        }
    } */

    /** The following functions are used to test UserInfoDataStore.kt
    val userNameFlow = useCases.getUserName().asLiveData()
    val amountOfVoc = useCases.getAmountOfVoc().asLiveData()
    val isDarkMode = useCases.getIsDarkMode().asLiveData()

    fun setUserName(newUserName: String) {
        viewModelScope.launch {
            useCases.setUserName(newUserName)
        }
    }

    fun setAmountOfVoc(newAmount: Int) {
        viewModelScope.launch {
            useCases.setAmountOfVoc(newAmount)
        }
    }

    fun setIsDarkMode(darkMode: Boolean) {
        viewModelScope.launch {
            useCases.setIsDarkMode(darkMode)
        }
    }*/
}