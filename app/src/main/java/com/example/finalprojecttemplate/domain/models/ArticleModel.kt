package com.example.finalprojecttemplate.domain.models

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles_backup_table")
data class ArticleModel(
    @PrimaryKey
    val id: Int,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val image: Uri,
    @ColumnInfo
    val answer: Map<Int, String>,
    @ColumnInfo
    val content: String
) {
    companion object {
        fun emptyArticleModel() =
            ArticleModel(
                id = -1,
                name = "",
                image = "".toUri(),
                answer = mapOf(),
                content = ""
            )
    }
}
