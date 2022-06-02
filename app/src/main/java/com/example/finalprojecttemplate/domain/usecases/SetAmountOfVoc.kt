package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SetAmountOfVoc(
    val repository: Repository
) {
    suspend operator fun invoke(newAmount: Int) {
        repository.setAmountOfVoc(newAmount = newAmount)
    }
}