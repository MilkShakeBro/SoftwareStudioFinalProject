package com.example.finalprojecttemplate.data.data_source

import androidx.room.*
import com.example.finalprojecttemplate.domain.models.Achievement
import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.models.ThemeDataModel
import com.example.finalprojecttemplate.domain.models.VocabularySetModel


@Database(entities = [Achievement::class, ArticleModel::class, VocabularySetModel::class, ThemeDataModel::class], version = 1, exportSchema = false)
@TypeConverters(LocalDatabaseConverter::class)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun localDatabaseDao() : LocalDatabaseDao
}