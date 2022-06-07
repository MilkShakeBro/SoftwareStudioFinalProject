package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.repository.Repository

class SetIsDarkModeUseCase(
    val repository: Repository
) {
    operator fun invoke(isDarkMode: Boolean) {
        repository.setIsDarkMode(darkMode = isDarkMode)
    }
}