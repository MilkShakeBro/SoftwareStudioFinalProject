package com.example.finalprojecttemplate.domain.repository

import com.example.finalprojecttemplate.domain.models.*
import kotlinx.coroutines.flow.Flow

interface Repository {

    // example
    suspend fun getArticleByIndex(index: Int): ArticleModel

    // Gamepage
    suspend fun getVocabularySetByIndex(index: Int): VocabularySetModel

    // History Data
    fun getHistoryData(userid: Int): HistoryDataModel

    // Homepage
    suspend fun getHomePageInfo(userid: Int): HomePageInfoModel

    // Theme
    suspend fun getThemeData(index: Int): ThemeDataModel

    // Profile
    suspend fun getAchievement(userid: Int): AchievementSetModel
    fun getPersonalInfo(userid: Int): PersonalInfoModel
    suspend fun addAchievement(achievement: Achievement)
    suspend fun getAllAchievements(): List<Achievement>

    // Preference
    fun getUserName(): String
    fun getAmountOfVoc(): Int
    fun getIsDarkMode(): Boolean
    fun setUserName(newName: String)
    fun setAmountOfVoc(newAmount: Int)
    fun setIsDarkMode(darkMode: Boolean)
}