package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.AchievementSetModel
import com.example.finalprojecttemplate.domain.repository.Repository

class GetAchievement (
    private val repository: Repository
        ) {
    suspend operator fun invoke(userid: Int): AchievementSetModel {
        return repository.getAchievement(userid)
    }
}