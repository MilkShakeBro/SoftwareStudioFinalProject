package com.example.finalprojecttemplate.domain.usecases

data class UseCases(
    val getArticleUseCase: GetArticleUseCase,
    val getVocabularySet: GetVocabularySet,
    val getHistoryData: GetHistoryData,
    val getHomePageInfo: GetHomePageInfo,
    val getThemeData: GetThemeData,
    val getAchievement: GetAchievement,
    val getPersonalInfo: GetPersonalInfo,
    val getUserName: GetUserName,
    val getAmountOfVoc: GetAmountOfVoc,
    val getIsDarkMode: GetIsDarkMode,
    val setAmountOfVocUseCase: SetAmountOfVocUseCase,
    val setIsDarkModeUseCase: SetIsDarkModeUseCase,
    val setUserNameUseCase: SetUserNameUseCase
)
