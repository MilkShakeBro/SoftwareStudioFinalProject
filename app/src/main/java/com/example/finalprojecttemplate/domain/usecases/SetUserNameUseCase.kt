package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.repository.Repository

class SetUserNameUseCase(
    val repository: Repository
) {
    operator fun invoke(newName: String) {
        repository.setUserName(newName = newName)
    }
}