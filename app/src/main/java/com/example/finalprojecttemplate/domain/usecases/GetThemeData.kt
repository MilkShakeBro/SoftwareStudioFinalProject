package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.ThemeDataModel
import com.example.finalprojecttemplate.domain.repository.Repository

class GetThemeData(
    private val repository: Repository
) {
    operator fun invoke(index: Int): ThemeDataModel {
        return repository.getThemeData(index)
    }
}