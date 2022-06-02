package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.repository.Repository

class SetUserName(
    val repository: Repository
) {
    suspend operator fun invoke(newName: String) {
        repository.setUserName(newName = newName)
    }
}