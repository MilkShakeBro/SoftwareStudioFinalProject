package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.Achievement
import com.example.finalprojecttemplate.domain.repository.Repository

class AddAchievementUseCase (
    private val repository: Repository
) {
    suspend operator fun invoke(achievement: Achievement) {
        repository.addAchievement(achievement)
    }
}