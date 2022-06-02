package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.HomePageInfoModel
import com.example.finalprojecttemplate.domain.repository.Repository

class GetHomePageInfo(
    private val repository: Repository
) {
    suspend operator fun invoke(userid: Int): HomePageInfoModel {
        return repository.getHomePageInfo(userid)
    }
}