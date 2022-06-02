package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetUserName (
    val repository: Repository
) {
    operator fun invoke(): Flow<String> {
        return repository.getUserName()
    }
}