package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.repository.Repository

class GetArticleUseCase(
    private val repository: Repository
) {
    operator fun invoke(index: Int) : ArticleModel {
        return repository.getArticleByIndex(index)
    }
}