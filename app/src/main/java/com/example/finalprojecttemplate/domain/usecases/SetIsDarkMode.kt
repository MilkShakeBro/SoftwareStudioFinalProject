package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.repository.Repository

class SetIsDarkMode(
    val repository: Repository
) {
    suspend operator fun invoke(isDarkMode: Boolean) {
        repository.setIsDarkMode(darkMode = isDarkMode)
    }
}