package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.VocabularySetModel
import com.example.finalprojecttemplate.domain.repository.Repository

class GetVocabularySet (
    private val repository: Repository
) {
    operator fun invoke(index: Int): VocabularySetModel {
        return repository.getVocabularySetByIndex(index)
    }
}