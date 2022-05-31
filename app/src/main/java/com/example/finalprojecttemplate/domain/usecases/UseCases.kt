package com.example.finalprojecttemplate.domain.usecases

data class UseCases(
    val getArticleUseCase: GetArticleUseCase,
    val getVocabularySet: GetVocabularySet,
    val getHistoryData: GetHistoryData,
    val getHomePageInfo: GetHomePageInfo,
    val getThemeData: GetThemeData,
    val getAchievement: GetAchievement,
)
