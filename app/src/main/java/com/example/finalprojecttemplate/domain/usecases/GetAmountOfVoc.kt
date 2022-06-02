package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.repository.Repository

class GetAmountOfVoc(
    val repository: Repository
) {
    operator fun invoke() = repository.getAmountOfVoc()
}