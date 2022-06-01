package com.example.finalprojecttemplate.domain.usecases

import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.models.HistoryDataModel
import com.example.finalprojecttemplate.domain.repository.Repository

class GetHistoryData(
    private val repository: Repository
) {
    operator fun invoke(userid: Int) : HistoryDataModel {
        return repository.getHistoryData(userid)
    }
}