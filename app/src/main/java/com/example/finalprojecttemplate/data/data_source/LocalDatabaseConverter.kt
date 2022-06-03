package com.example.finalprojecttemplate.data.data_source

import android.net.Uri
import androidx.room.TypeConverter

class LocalDatabaseConverter {

    @TypeConverter
    fun uriToString(uri: Uri) = uri.toString()

    @TypeConverter
    fun stringToUri(str: String): Uri = Uri.parse(str)
}