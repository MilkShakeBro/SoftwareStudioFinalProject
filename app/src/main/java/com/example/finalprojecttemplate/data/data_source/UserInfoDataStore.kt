package com.example.finalprojecttemplate.data.data_source

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.asLiveData
import com.example.finalprojecttemplate.domain.usecases.GetIsDarkMode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

private val APP_DATASTORE_NAME = "app_datastore"

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = APP_DATASTORE_NAME
)

class UserInfoDataStore(val context: Context) {
    // List of data stored in the preference data store
    private val USER_NAME = stringPreferencesKey("user_name")
    private val AMOUNT_OF_MEMORIZED_VOC = intPreferencesKey("amount_of_memorized_voc")
    private val IS_DRAK_MODE = booleanPreferencesKey("is_dark_mode")

    val dataStoreUserNameFlow: Flow<String> = context.dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            }
        }
        .map { dataStore ->
            dataStore[USER_NAME] ?: "(Not enter name yet)"
        }

    val dataStoreAmountOfVocFlow: Flow<Int> = context.dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            }
        }
        .map { dataStore ->
            dataStore[AMOUNT_OF_MEMORIZED_VOC] ?: 0
        }

    val dataStoreIsDarkModeFlow: Flow<Boolean> = context.dataStore.data
        .catch {
            if (it is IOException) {
                it.printStackTrace()
                emit(emptyPreferences())
            }
        }
        .map { dataStore ->
            dataStore[IS_DRAK_MODE] ?: false
        }

    suspend fun saveUserNameToDataStore(newUserName: String) {
        context.dataStore.edit { dataStore ->
            dataStore[USER_NAME] = newUserName
        }
    }

    suspend fun saveAmountOfVocToDataStore(newAmount: Int) {
        context.dataStore.edit { dataStore ->
            dataStore[AMOUNT_OF_MEMORIZED_VOC] = newAmount
        }
    }

    suspend fun saveIsDarkModeToDataStoreStore(isDarkMode: Boolean) {
        context.dataStore.edit { dataStore ->
            dataStore[IS_DRAK_MODE] = isDarkMode
        }
    }

    suspend fun increaseAmountOfVocByToDataStore(inc: Int) {
        context.dataStore.edit { dataStore ->
            val originalAmount = dataStoreAmountOfVocFlow.asLiveData().value ?: 0
            dataStore[AMOUNT_OF_MEMORIZED_VOC] = originalAmount + inc
        }
    }
}