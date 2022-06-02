package com.example.finalprojecttemplate.domain.repository

import com.example.finalprojecttemplate.domain.models.*
import kotlinx.coroutines.flow.Flow

interface Repository {

    // example
    fun getArticleByIndex(index: Int): ArticleModel

    // Gamepage
    fun getVocabularySetByIndex(index: Int): VocabularySetModel

    // History Data
    fun getHistoryData(userid: Int): HistoryDataModel

    // Homepage
    fun getHomePageInfo(userid: Int): HomePageInfoModel

    // Theme
    fun getThemeData(index: Int): ThemeDataModel

    // Profile
    fun getAchievement(userid: Int): AchievementSetModel
    fun getPersonalInfo(userid: Int): PersonalInfoModel

    // Preference
    fun getUserName(): Flow<String>
    fun getAmountOfVoc(): Flow<Int>
    fun getIsDarkMode(): Flow<Boolean>
    suspend fun setUserName(newName: String)
    suspend fun setAmountOfVoc(newAmount: Int)
    suspend fun setIsDarkMode(darkMode: Boolean)
    suspend fun increaseAmountOfVocBy(inc: Int)
}