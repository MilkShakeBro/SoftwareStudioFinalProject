package com.example.finalprojecttemplate.data.data_source

import androidx.room.*
import com.example.finalprojecttemplate.domain.models.Achievement
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalDatabaseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(achievement: Achievement)

    @Update
    suspend fun update(achievement: Achievement)

    @Delete
    suspend fun delete(achievement: Achievement)

    @Query("SELECT * from achievement_set_table ORDER BY id ASC")
    fun getAchievements(): Flow<List<Achievement>>

    @Query("SELECT * from achievement_set_table WHERE id = :id")
    fun getAchievementById(id: Int): Flow<Achievement>
}