package com.example.finalprojecttemplate.data

import com.example.finalprojecttemplate.data.data_source.FakeDatabase
import com.example.finalprojecttemplate.domain.models.*
import com.example.finalprojecttemplate.domain.repository.Repository

class RepositoryImpl(
    val fakeDatabase: FakeDatabase
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

    override fun getHomePageInfo(userid: Int): HomePageInfoModel {
        return fakeDatabase.getHomePageInfo(userid)
    }

    override fun getThemeData(index: Int): ThemeDataModel {
        return fakeDatabase.getThemeData(index)
    }

    override fun getAchievement(userid: Int): AchievementSetModel {
        return fakeDatabase.getAchievement(userid)
    }

    override fun getPersonalInfo(userid: Int): PersonalInfoModel {
        return fakeDatabase.getPersonalInfo(userid)
    }
}