package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.repository.Repository

class GetIsDarkMode(
    val repository: Repository
) {
    operator fun invoke() = repository.getIsDarkMode()
}