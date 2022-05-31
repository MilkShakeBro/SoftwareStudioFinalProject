package com.example.finalprojecttemplate.domain.repository

import com.example.finalprojecttemplate.domain.models.*

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

}