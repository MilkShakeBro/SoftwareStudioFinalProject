package com.example.finalprojecttemplate.data

import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.asLiveData
import com.apollographql.apollo3.ApolloClient
import com.example.finalprojecttemplate.ArticlesQuery
import com.example.finalprojecttemplate.VocabularySetQuery
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

//    private suspend fun getVocabularySet(id: Int) {
//        try {
//            withContext(Dispatchers.IO) {
//                val apolloClient = ApolloClient.Builder()
//                    .serverUrl("http://10.0.2.2:3000/graphql")
//                    .build()
//                // Execute your query. This will suspend until the response is received.
//                val response = apolloClient.query(VocabularySetQuery(id)).execute()
//                val vocabularySet: MutableList<Vocabulary> = mutableListOf()
//
//                for (i in 0..13) {
//                    vocabularySet.add(
//                        Vocabulary(
//                            id = response.data?.vocabularySet?.vocabularies?.get(i)!!.id.toInt(),
//                            word = response.data?.vocabularySet?.vocabularies?.get(i)!!.word,
//                            chinese = response.data?.vocabularySet?.vocabularies?.get(i)!!.chinese,
//                            breakpoint = response.data?.vocabularySet?.vocabularies?.get(i)!!.breakpoint
//                        )
//                    )
//                }
//
//                VocabularySetModel(
//                    id = response.data?.vocabularySet?.id!!.toInt(),
//                    name = response.data?.vocabularySet!!.name,
//                    image = response.data?.vocabularySet!!.image.toUri(),
//                    vocabularySet = vocabularySet
//                )
//
//                return@withContext response.data.toString()
//            }.toString()
//        } catch(e: Exception) {
//            System.out.println("Error " + e.message);
//        }
//    }

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
            val dataFromServer: VocabularySetModel
            withContext(Dispatchers.IO) {
                val apolloClient = ApolloClient.Builder()
                    .serverUrl("http://10.0.2.2:3000/graphql")
                    .build()
                // Execute your query. This will suspend until the response is received.
                val response = apolloClient.query(VocabularySetQuery(index)).execute()
                val vocabularySet: MutableList<Vocabulary> = mutableListOf()

                for (i in 0..13) {
                    vocabularySet.add(
                        Vocabulary(
                            id = response.data?.vocabularySet?.vocabularies?.get(i)!!.id.toInt(),
                            word = response.data?.vocabularySet?.vocabularies?.get(i)!!.word,
                            chinese = response.data?.vocabularySet?.vocabularies?.get(i)!!.chinese,
                            breakpoint = response.data?.vocabularySet?.vocabularies?.get(i)!!.breakpoint
                        )
                    )
                }
                dataFromServer = VocabularySetModel(
                    id = response.data?.vocabularySet?.id!!.toInt(),
                    name = response.data?.vocabularySet!!.name,
                    image = response.data?.vocabularySet!!.image.toUri(),
                    vocabularySet = vocabularySet
                )
            }

            dataFromServer
//            val dataFromRemote = fakeDatabase.getVocabularySetByIndex(index)
//            localDatabaseDao.insert(dataFromRemote)
//            dataFromRemote
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

    override suspend fun getAchievement(userid: Int): AchievementSetModel {
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

    override fun getUserName(): String {
        return "userInfoDataStore.UserName"
    }

    override fun getAmountOfVoc(): Int {
        return 0
    }

    override fun getIsDarkMode(): Boolean {
        return userInfoDataStore.getIsDarkModeFromDataStoreStore()
    }

    override fun setUserName(newName: String) {
        userInfoDataStore.saveUserNameToDataStore(newName)
    }

    override fun setAmountOfVoc(newAmount: Int) {
        userInfoDataStore.saveAmountOfVocToDataStore(newAmount)
    }

    override fun setIsDarkMode(darkMode: Boolean) {
        userInfoDataStore.saveIsDarkModeToDataStoreStore(darkMode)
    }
}