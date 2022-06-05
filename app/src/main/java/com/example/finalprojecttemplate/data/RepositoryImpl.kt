package com.example.finalprojecttemplate.data

import com.example.finalprojecttemplate.data.data_source.FakeDatabase
import com.example.finalprojecttemplate.data.data_source.UserInfoDataStore
import com.example.finalprojecttemplate.domain.models.*
import com.example.finalprojecttemplate.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.newSingleThreadContext

class RepositoryImpl(
    val fakeDatabase: FakeDatabase,
    val userInfoDataStore: UserInfoDataStore
): Repository {

    override fun getArticleByIndex(index: Int): ArticleModel {
        return fakeDatabase.getArticleByIndex(index)
    }

    override fun getVocabularySetByIndex(index: Int): VocabularySetModel {
        return fakeDatabase.getVocabularySetByIndex(index)
    }

    override fun getHistoryData(userid: Int): HistoryDataModel {
        return fakeDatabase.getHistoryData(userid)
    }

    override suspend fun getHomePageInfo(userid: Int): HomePageInfoModel {
        return fakeDatabase.getHomePageInfo(userid)
    }

    override fun getThemeData(index: Int): ThemeDataModel {
        return fakeDatabase.getThemeData(index)
    }

    override suspend fun getAchievement(userid: Int): AchievementSetModel {
        return fakeDatabase.getAchievement(userid)
    }

    override fun getPersonalInfo(userid: Int): PersonalInfoModel {
        return fakeDatabase.getPersonalInfo(userid)
    }

    override fun getUserName(): Flow<String> {
        return userInfoDataStore.dataStoreUserNameFlow
    }

    override fun getAmountOfVoc(): Flow<Int> {
        return userInfoDataStore.dataStoreAmountOfVocFlow
    }

    override fun getIsDarkMode(): Flow<Boolean> {
        return userInfoDataStore.dataStoreIsDarkModeFlow
    }

    override suspend fun setUserName(newName: String) {
        userInfoDataStore.saveUserNameToDataStore(newName)
    }

    override suspend fun setAmountOfVoc(newAmount: Int) {
        userInfoDataStore.saveAmountOfVocToDataStore(newAmount)
    }

    override suspend fun setIsDarkMode(darkMode: Boolean) {
        userInfoDataStore.saveIsDarkModeToDataStoreStore(darkMode)
    }

    override suspend fun increaseAmountOfVocBy(inc: Int) {
        userInfoDataStore.increaseAmountOfVocByToDataStore(inc)
    }
}