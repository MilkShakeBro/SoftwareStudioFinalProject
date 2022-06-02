package com.example.finalprojecttemplate.di

import android.app.Application
import com.example.finalprojecttemplate.data.RepositoryImpl
import com.example.finalprojecttemplate.data.data_source.FakeDatabase
import com.example.finalprojecttemplate.data.data_source.UserInfoDataStore
import com.example.finalprojecttemplate.domain.repository.Repository
import com.example.finalprojecttemplate.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFakeDatabase(app: Application): FakeDatabase {
        return FakeDatabase()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: FakeDatabase, ds: UserInfoDataStore): Repository {
        return RepositoryImpl(db, ds)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: Repository): UseCases {
        return UseCases(
            getArticleUseCase = GetArticleUseCase(repository),
            getVocabularySet = GetVocabularySet(repository),
            getHistoryData = GetHistoryData(repository),
            getHomePageInfo = GetHomePageInfo(repository),
            getThemeData = GetThemeData(repository),
            getAchievement = GetAchievement(repository),
            getPersonalInfo = GetPersonalInfo(repository),
            getIsDarkMode = GetIsDarkMode(repository),
            getAmountOfVoc = GetAmountOfVoc(repository),
            getUserName = GetUserName(repository),
            setAmountOfVoc = SetAmountOfVoc(repository),
            setIsDarkMode = SetIsDarkMode(repository),
            setUserName = SetUserName(repository)
        )
    }

    @Provides
    @Singleton
    fun provideUserInfoDataStore(app: Application): UserInfoDataStore {
        return UserInfoDataStore(app.applicationContext)
    }
}