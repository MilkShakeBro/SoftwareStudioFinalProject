package com.example.finalprojecttemplate.di

import android.app.Application
import androidx.room.Room
import com.example.finalprojecttemplate.data.RepositoryImpl
import com.example.finalprojecttemplate.data.data_source.FakeDatabase
import com.example.finalprojecttemplate.data.data_source.LocalDatabase
import com.example.finalprojecttemplate.data.data_source.LocalDatabaseDao
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
    fun provideLocalDatabase(app: Application): LocalDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            LocalDatabase::class.java,
            "game_to_mem_local_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: FakeDatabase, ds: UserInfoDataStore, localdb: LocalDatabase): Repository {
        return RepositoryImpl(db, ds, localdb.localDatabaseDao())
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
            setAmountOfVocUseCase = SetAmountOfVocUseCase(repository),
            setIsDarkModeUseCase = SetIsDarkModeUseCase(repository),
            setUserNameUseCase = SetUserNameUseCase(repository),
            addAchievementUseCase = AddAchievementUseCase(repository),
            getAllAchievementsUseCase = GetAllAchievementsUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideUserInfoDataStore(app: Application): UserInfoDataStore {
        return UserInfoDataStore(app.applicationContext)
    }
}