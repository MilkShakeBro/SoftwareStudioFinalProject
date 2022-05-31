package com.example.finalprojecttemplate.domain.models

import android.net.Uri

data class HomePageInfoModel (
    val articleInfo: List<HomePageInfo>,
    val vocabularySetInfo: List<HomePageInfo>,
    val themeInfo: List<HomePageInfo>,
)

data class HomePageInfo (
    val id: Int,
    val img: Uri,
    val name: String,
)