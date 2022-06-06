package com.example.finalprojecttemplate.domain.models

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class AchievementSetModel(
    val id: Int,
    val achievement: List<Achievement>,
)

@Entity(tableName = "achievement_set_table")
data class Achievement (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val img: Uri,
    @ColumnInfo
    val description: String,
    @ColumnInfo
    val obtained: Boolean
)

fun Achievement.showInString(): String =
    String.format("id: $id\nimg: ${img}\ndescription: ${description}\nobtained: ${obtained}\n\n")