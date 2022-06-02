package com.example.finalprojecttemplate.ui.homepage

import androidx.lifecycle.*
import com.example.finalprojecttemplate.domain.models.HomePageInfo
import com.example.finalprojecttemplate.domain.models.HomePageInfoModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

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