package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.PersonalInfoModel
import com.example.finalprojecttemplate.domain.repository.Repository

class GetPersonalInfo(
    private val repository: Repository
) {
    operator fun invoke(userid: Int): PersonalInfoModel {
        return repository.getPersonalInfo(userid)
    }
}