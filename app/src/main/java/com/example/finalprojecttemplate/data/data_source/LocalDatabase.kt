package com.example.finalprojecttemplate.data.data_source

import androidx.room.*
import com.example.finalprojecttemplate.domain.models.Achievement


@Database(entities = [Achievement::class], version = 1, exportSchema = false)
@TypeConverters(LocalDatabaseConverter::class)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun localDatabaseDao() : LocalDatabaseDao
}