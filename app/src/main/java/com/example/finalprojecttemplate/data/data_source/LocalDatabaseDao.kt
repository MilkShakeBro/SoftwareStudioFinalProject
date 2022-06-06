package com.example.finalprojecttemplate.data.data_source

import androidx.room.*
import com.example.finalprojecttemplate.domain.models.*
import kotlinx.coroutines.delay
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
    suspend fun getAchievements(): List<Achievement>

    @Query("SELECT * from achievement_set_table WHERE id = :id")
    suspend fun getAchievementById(id: Int): Achievement?


    /** Article Model */
    @Query("SELECT * from articles_backup_table WHERE id = :id LIMIT 1")
    suspend fun getArticleModelById(id: Int): ArticleModel?

    @Query("SELECT * from articles_backup_table ORDER BY id ASC")
    suspend fun getArticleModels(): List<ArticleModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articleModel: ArticleModel)

    /** VocabularySetModel */
    @Query("SELECT * from vocabulary_set_backup_table WHERE id = :id LIMIT 1")
    suspend fun getVocabularySetById(id: Int): VocabularySetModel?

    @Query("SELECT * from vocabulary_set_backup_table ORDER BY id ASC")
    suspend fun getVocabularySets(): List<VocabularySetModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vocabularySetModel: VocabularySetModel)

    /** ThemeDataModel */
    @Query("SELECT * from theme_data_back_up_table WHERE id = :id LIMIT 1")
    suspend fun getThemeById(id: Int) : ThemeDataModel?

    @Query("SELECT * from theme_data_back_up_table ORDER BY id ASC")
    suspend fun getAllThemeData(): List<ThemeDataModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(themeDataModel: ThemeDataModel)

    suspend fun getHomePageInfo(userid: Int) : HomePageInfoModel {
        val articleInfo: MutableList<HomePageInfo> = mutableListOf()
        val vocabularySetInfo: MutableList<HomePageInfo> = mutableListOf()
        val themeInfo: MutableList<HomePageInfo> = mutableListOf()

        val articles = getArticleModels()
        val vocabularySets = getVocabularySets()
        val themeData = getAllThemeData()

        articles.forEach{ item->articleInfo.add(HomePageInfo(item.id, item.image, item.name)) }
        vocabularySets.forEach{ item->vocabularySetInfo.add(HomePageInfo(item.id, item.image, item.name)) }
        themeData.forEach{ item->themeInfo.add(HomePageInfo(item.id, item.image, "item.name???")) }

        return if (userid in 0 until 5) HomePageInfoModel(articleInfo, vocabularySetInfo, themeInfo)
        else HomePageInfoModel(
            mutableListOf(),
            mutableListOf(),
            mutableListOf()
        )
    }
}