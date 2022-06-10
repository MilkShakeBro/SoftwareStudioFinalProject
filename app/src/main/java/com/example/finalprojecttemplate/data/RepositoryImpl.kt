package com.example.finalprojecttemplate.data

import android.util.Log
import androidx.core.net.toUri
import androidx.lifecycle.asLiveData
import com.apollographql.apollo3.ApolloClient
import com.example.finalprojecttemplate.*
import com.example.finalprojecttemplate.data.data_source.FakeDatabase
import com.example.finalprojecttemplate.data.data_source.LocalDatabaseDao
import com.example.finalprojecttemplate.data.data_source.UserInfoDataStore
import com.example.finalprojecttemplate.domain.models.*
import com.example.finalprojecttemplate.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import kotlin.math.atan

class RepositoryImpl(
    private val fakeDatabase: FakeDatabase,
    private val userInfoDataStore: UserInfoDataStore,
    private val localDatabaseDao: LocalDatabaseDao
): Repository {

    override suspend fun getArticleByIndex(index: Int): ArticleModel {
//        return fakeDatabase.getArticleByIndex(index)
        return try {
        val dataFromServer: ArticleModel
            withContext(Dispatchers.IO) {
                val apolloClient = ApolloClient.Builder()
                    .serverUrl("http://10.0.2.2:3000/graphql")
                    .build()
                // Execute your query. This will suspend until the response is received.
                val response = apolloClient.query(ArticleQuery(index)).execute()
                val responseAnswer = response.data?.article?.answers
                val responseQuestion = response.data?.article?.questions
                val answer: MutableMap<Int, String> = mutableMapOf()
                val question: MutableMap<Int, List<String>> = mutableMapOf()

                responseAnswer?.forEach {
                    if (it != null) {
                        answer.put(it.answer_id.toInt(), it.answer_string)
                    }
                }
                responseQuestion?.forEach { mapOfIdAndListOfString ->
                    if (mapOfIdAndListOfString != null) {
                        val listOfString = mutableListOf<String>()
                        mapOfIdAndListOfString?.question_string.forEach {
                            if (it != null) {
                                listOfString.add(it)
                            }
                        }
                        question.put(
                            mapOfIdAndListOfString.question_id.toInt(),
                            listOfString
                        )
                    }
                }

//                for (i in 0..3) {
//                    answer[i+1] = response.data?.article?.answers?.get(i)!!.answer_string
//                }
//
//                for (i in 0..0) {
//                    question[i] = response.data?.article?.questions?.get(i)!!.question_string as List<String>
//                }

                dataFromServer = ArticleModel(
                    id = response.data?.article?.id!!.toInt(),
                    name = response.data?.article!!.name,
                    image = response.data?.article!!.image.toUri(),
                    answer = answer,
                    question = question,
                    content = response.data?.article!!.content
                )
            }

            dataFromServer
//            val dataFromRemote = fakeDatabase.getArticleByIndex(index)
//            localDatabaseDao.insert(dataFromRemote)
//            dataFromRemote
        } catch (e: Exception) {
            e.printStackTrace()
            Log.d("RepositoryImpl", "Error occurs")
            localDatabaseDao.getArticleModelById(index) ?: ArticleModel.emptyArticleModel()
        }
    }

    override suspend fun getVocabularySetByIndex(index: Int): VocabularySetModel {
//        return fakeDatabase.getVocabularySetByIndex(index)
        return try {
//            val dataFromServer: VocabularySetModel
//            withContext(Dispatchers.IO) {
//                val apolloClient = ApolloClient.Builder()
//                    .serverUrl("http://10.0.2.2:3000/graphql")
//                    .build()
//                // Execute your query. This will suspend until the response is received.
//                val response = apolloClient.query(VocabularySetQuery(index)).execute()
//                val vocabularySet: MutableList<Vocabulary> = mutableListOf()
//
//                for (i in 0..2) {
//                    vocabularySet.add(
//                        Vocabulary(
//                            id = response.data?.vocabularySet?.vocabularies?.get(i)!!.id.toInt(),
//                            word = response.data?.vocabularySet?.vocabularies?.get(i)!!.word,
//                            chinese = response.data?.vocabularySet?.vocabularies?.get(i)!!.chinese,
//                            breakpoint = response.data?.vocabularySet?.vocabularies?.get(i)!!.breakpoint
//                        )
//                    )
//                }
//                dataFromServer = VocabularySetModel(
//                    id = response.data?.vocabularySet?.id!!.toInt(),
//                    name = response.data?.vocabularySet!!.name,
//                    image = response.data?.vocabularySet!!.image.toUri(),
//                    vocabularySet = vocabularySet
//                )
//            }
//
//            dataFromServer
            val dataFromRemote = fakeDatabase.getVocabularySetByIndex(index)
            localDatabaseDao.insert(dataFromRemote)
            dataFromRemote
        } catch (e: Exception) {
//            e.printStackTrace()
            Log.d("Error", e.toString())
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
//            fakeDatabase.getHomePageInfo(userid)
            val apolloClient = ApolloClient.Builder()
                    .serverUrl("http://10.0.2.2:3000/graphql")
                    .build()
                // Execute your query. This will suspend until the response is received.
            val response = apolloClient.query(HomePageQuery()).execute()
            val articleInfos = mutableListOf<HomePageInfo>()
            val vocabularyInfos = mutableListOf<HomePageInfo>()
            val themeInfos = mutableListOf<HomePageInfo>()

            val homePageInfo = response.data?.homePageInfos?.get(0)
            homePageInfo?.articleInfos?.forEach {
                if (it != null) {
                    articleInfos.add(
                        HomePageInfo(
                            id = it.id.toInt(),
                            img = it.image.toUri(),
                            name = it.name
                        )
                    )
                }
            }

            homePageInfo?.vocabularySetInfos?.forEach {
                if (it != null) {
                    vocabularyInfos.add(
                        HomePageInfo(
                            id = it.id.toInt(),
                            img = it.image.toUri(),
                            name = it.name
                        )
                    )
                }
            }

            homePageInfo?.themeInfos?.forEach {
                if (it != null) {
                    themeInfos.add(
                        HomePageInfo(
                            id = it.id.toInt(),
                            img = it.image.toUri(),
                            name = it.name
                        )
                    )
                }
            }

            return HomePageInfoModel(
                articleInfos,
                vocabularyInfos,
                themeInfos
            )
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
//        return localDatabaseDao.getAchievements()
        return try {
            val apolloClient = ApolloClient.Builder()
                .serverUrl("http://10.0.2.2:3000/graphql")
                .build()
            // Execute your query. This will suspend until the response is received.
            val response = apolloClient.query(AchievementsQuery()).execute()
            val achievementsList = response.data?.achievementSets
            val listOfAchievement = mutableListOf<Achievement>()

            achievementsList?.forEach {
                if (it != null) {
                    listOfAchievement.add(
                        Achievement(
                            id = it.id.toInt(),
                            description = it.description,
                            img = it.image.toUri(),
                            obtained = it.obtained
                        )
                    )
                }
            }

            listOfAchievement
        } catch (e: Exception) {
            e.printStackTrace()
            listOf()
        }
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