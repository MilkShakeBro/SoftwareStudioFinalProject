package com.example.finalprojecttemplate.data

import android.util.Log
import androidx.lifecycle.asLiveData
import com.example.finalprojecttemplate.data.data_source.FakeDatabase
import com.example.finalprojecttemplate.data.data_source.LocalDatabaseDao
import com.example.finalprojecttemplate.data.data_source.UserInfoDataStore
import com.example.finalprojecttemplate.domain.models.*
import com.example.finalprojecttemplate.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class RepositoryImpl(
    private val fakeDatabase: FakeDatabase,
    private val userInfoDataStore: UserInfoDataStore,
    private val localDatabaseDao: LocalDatabaseDao
): Repository {

    override suspend fun getArticleByIndex(index: Int): ArticleModel {
//        return fakeDatabase.getArticleByIndex(index)
        return try {
            val dataFromRemote = fakeDatabase.getArticleByIndex(index)
            localDatabaseDao.insert(dataFromRemote)
            dataFromRemote
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("RepositoryImpl", "Error occurs")
            localDatabaseDao.getArticleModelById(index) ?: ArticleModel.emptyArticleModel()
        }
    }

    override suspend fun getVocabularySetByIndex(index: Int): VocabularySetModel {
//        return fakeDatabase.getVocabularySetByIndex(index)
        return try {
            val dataFromRemote = fakeDatabase.getVocabularySetByIndex(index)
            localDatabaseDao.insert(dataFromRemote)
            dataFromRemote
        } catch (e: Exception) {
//            e.printStackTrace()
            Log.d("RepositoryImpl", "Error occurs")
            localDatabaseDao.getVocabularySetById(index) ?: VocabularySetModel.emptyVocabularySetModel()
        }
    }

    override fun getHistoryData(userid: Int): HistoryDataModel {
        return fakeDatabase.getHistoryData(userid)
    }

    override suspend fun getHomePageInfo(userid: Int): HomePageInfoModel {
//        return fakeDatabase.getHomePageInfo(userid)
        return try {
            fakeDatabase.getHomePageInfo(userid)
        } catch (e: Exception) {
            val dataFromLocal = localDatabaseDao.getHomePageInfo(userid)
            if (dataFromLocal.articleInfo.isEmpty()
                && dataFromLocal.vocabularySetInfo.isEmpty()
                && dataFromLocal.themeInfo.isEmpty()) {
                throw Exception("${e.message} and no data in the local database as well.")
            } else {
                dataFromLocal
            }
        }
    }

    override suspend fun getThemeData(index: Int): ThemeDataModel {
//        return fakeDatabase.getThemeData(index)
        return try {
            val dataFromRemote = fakeDatabase.getThemeData(index)
            localDatabaseDao.insert(dataFromRemote)
            dataFromRemote
        } catch (e: Exception) {
//            e.printStackTrace()
            Log.d("RepositoryImpl", "Error occurs")
            localDatabaseDao.getThemeById(index) ?: ThemeDataModel.emptyThemeDataModel()
        }
    }

    override fun getAchievement(userid: Int): AchievementSetModel {
        return fakeDatabase.getAchievement(userid)
    }

    override fun getPersonalInfo(userid: Int): PersonalInfoModel {
        return fakeDatabase.getPersonalInfo(userid)
    }

    override suspend fun addAchievement(achievement: Achievement) {
        localDatabaseDao.insert(achievement)
    }

    override suspend fun getAllAchievements(): List<Achievement> {
        return localDatabaseDao.getAchievements()
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