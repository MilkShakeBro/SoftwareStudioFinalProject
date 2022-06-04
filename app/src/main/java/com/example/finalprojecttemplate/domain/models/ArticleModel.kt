package com.example.finalprojecttemplate.domain.models

import android.net.Uri

data class ArticleModel(
    val id: Int,
    val name: String,
    val image: Uri,
    val answer: Map<Int, String>,
    val question: Map<Int, List<String>>,
    val content: String
)
