package com.example.finalprojecttemplate.ui.profile
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecttemplate.domain.models.AchievementSetModel
import com.example.finalprojecttemplate.domain.models.ArticleModel
import com.example.finalprojecttemplate.domain.usecases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowAchievementViewModel @Inject constructor (
    private val useCases: UseCases
): ViewModel() {

    private var index = 0
    private val _displayedAchievement = MutableLiveData<AchievementSetModel>()
    val displayedAchievement : LiveData<AchievementSetModel>
        get() = _displayedAchievement

    fun onEvent() {
        viewModelScope.launch {
            _displayedAchievement.value = useCases.getAchievement(index)
        }
    }
}