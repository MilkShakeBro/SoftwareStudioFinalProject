package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetArticleUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(index: Int) : ArticleModel {
        return repository.getArticleByIndex(index)
    }
}