package com.example.finalprojecttemplate.domain.models

import android.net.Uri

data class AchievementSetModel(
    val id: Int,
    val achievement: List<Achievement>,
)

data class Achievement (
    val id: Int,
    val img: Uri,
    val obtained: Boolean
)