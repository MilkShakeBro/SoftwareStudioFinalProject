package com.example.finalprojecttemplate.data.data_source

import android.content.Context
import android.preference.PreferenceDataStore
import android.util.Log
import androidx.core.content.edit
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import com.example.finalprojecttemplate.domain.usecases.GetIsDarkMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException

private val APP_DATASTORE_NAME = "app_datastore"

//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
//    name = APP_DATASTORE_NAME
//)

class UserInfoDataStore(context: Context) {
    // List of data stored in the preference data store
//    private val USER_NAME = stringPreferencesKey("user_name")
//    private val AMOUNT_OF_MEMORIZED_VOC = intPreferencesKey("amount_of_memorized_voc")
//    private val IS_DRAK_MODE = booleanPreferencesKey("is_dark_mode")
    private val USER_NAME = "user_name"
    private val AMOUNT_OF_MEMORIZED_VOC = "amount_of_memorized_voc"
    private val IS_DRAK_MODE = "is_dark_mode"

    private val sharedPreferences = context.getSharedPreferences(
        APP_DATASTORE_NAME, Context.MODE_PRIVATE
    )

//    val dataStoreUserNameFlow: Flow<String> = preference_datastore.data
//        .catch {
//            if (it is IOException) {
//                it.printStackTrace()
//                emit(emptyPreferences())
//            }
//        }
//        .map { dataStore ->
//            dataStore[USER_NAME] ?: "(Not enter name yet)"
//        }
//
//    val dataStoreAmountOfVocFlow: Flow<Int> = preference_datastore.data
//        .catch {
//            if (it is IOException) {
//                it.printStackTrace()
//                emit(emptyPreferences())
//            }
//        }
//        .map { dataStore ->
//            dataStore[AMOUNT_OF_MEMORIZED_VOC] ?: 0
//        }
//
//    val dataStoreIsDarkModeFlow: Flow<Boolean> = preference_datastore.data
//        .catch {
//            if (it is IOException) {
//                it.printStackTrace()
//                emit(emptyPreferences())
//            }
//        }
//        .map { dataStore ->
//            Log.d("HomePageViewModel", "Flow: ${dataStore[IS_DRAK_MODE] ?: false}")
//            dataStore[IS_DRAK_MODE] ?: false
//        }

    fun saveUserNameToDataStore(newUserName: String) {
//        context.dataStore.edit { dataStore ->
//            dataStore[USER_NAME] = newUserName
//        }
        sharedPreferences.edit {
            putString(USER_NAME, newUserName)
        }
    }

    fun saveAmountOfVocToDataStore(newAmount: Int) {
//        context.dataStore.edit { dataStore ->
//            dataStore[AMOUNT_OF_MEMORIZED_VOC] = newAmount
//        }
        sharedPreferences.edit {
            putInt(AMOUNT_OF_MEMORIZED_VOC, newAmount)
        }
    }

    fun saveIsDarkModeToDataStoreStore(isDarkMode: Boolean) {
//        context.dataStore.edit { dataStore ->
//            dataStore[IS_DRAK_MODE] = isDarkMode
//            Log.d("HomePageViewModel", isDarkMode.toString())
//        }
        sharedPreferences.edit {
            putBoolean(IS_DRAK_MODE, isDarkMode)
        }
    }

    fun getIsDarkModeFromDataStoreStore(): Boolean {
//        Log.d("HomePageViewModel", "Is Null? ${dataStoreIsDarkModeFlow.asLiveData().value == null}")
//        return dataStoreIsDarkModeFlow.asLiveData().value ?: false
        return sharedPreferences.getBoolean(IS_DRAK_MODE, false)
    }

//    suspend fun increaseAmountOfVocByToDataStore(inc: Int) {
//        context.dataStore.edit { dataStore ->
//            val originalAmount = dataStoreAmountOfVocFlow.asLiveData().value ?: 0
//            dataStore[AMOUNT_OF_MEMORIZED_VOC] = originalAmount + inc
//        }
//    }
}