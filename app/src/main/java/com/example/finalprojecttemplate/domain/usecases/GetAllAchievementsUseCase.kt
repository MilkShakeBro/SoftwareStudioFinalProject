package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.Achievement
import com.example.finalprojecttemplate.domain.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetAllAchievementsUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke() : List<Achievement> {
        return repository.getAllAchievements()
    }
}