package com.example.finalprojecttemplate.data.data_source

import android.net.Uri
import android.util.Log
import androidx.core.net.toUri
import androidx.room.TypeConverter
import com.example.finalprojecttemplate.domain.models.Coordinate
import com.example.finalprojecttemplate.domain.models.ThemeDataModel
import com.example.finalprojecttemplate.domain.models.Vocabulary
import com.example.finalprojecttemplate.domain.models.VocabularyForTheme
import java.io.*

class LocalDatabaseConverter {

    @TypeConverter
    fun uriToString(uri: Uri) = uri.toString()

    @TypeConverter
    fun stringToUri(str: String): Uri = Uri.parse(str)

    @Suppress("UNCHECKED_CAST")
    private fun <T> byteArrayToTypeT(byteArray: ByteArray): T {
        val byteArrayInputStream = ByteArrayInputStream(byteArray)
        val objectInput : ObjectInput = ObjectInputStream(byteArrayInputStream)
        val result = objectInput.readObject() as T
        objectInput.close()
        byteArrayInputStream.close()
        return result
    }

    private fun <T> typeTToByteArray(obj: T): ByteArray {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val objectOutputStream: ObjectOutputStream = ObjectOutputStream(byteArrayOutputStream)
        objectOutputStream.writeObject(obj)
        objectOutputStream.flush()
        val result = byteArrayOutputStream.toByteArray()
        byteArrayOutputStream.close()
        objectOutputStream.close()
        return result
    }

    @TypeConverter
    fun listOfVocabularyToByteArray(list: List<Vocabulary>): ByteArray
        = typeTToByteArray<List<Vocabulary>>(list)

    @TypeConverter
    fun byteArrayToListOfVocabulary(byteArray: ByteArray): List<Vocabulary>
        = byteArrayToTypeT<List<Vocabulary>>(byteArray)

    @TypeConverter
    fun listOfVocabularyForThemeToByteArray(list: List<VocabularyForTheme>): ByteArray
        = typeTToByteArray(list)

    @TypeConverter
    fun byteArrayToListOfVocabularyForTheme(byteArray: ByteArray): List<VocabularyForTheme>
        = byteArrayToTypeT(byteArray)

    @TypeConverter
    fun mapOfIntAndStringToByteArray(map: Map<Int, String>): ByteArray = typeTToByteArray(map)

    @TypeConverter
    fun byteArrayToMapOfIntAndString(byteArray: ByteArray): Map<Int, String> = byteArrayToTypeT(byteArray)

    /** Map<Int, List<String>>*/
    @TypeConverter
    fun mapOfIntAndListOfStringToByteArray(map: Map<Int, List<String>>): ByteArray = typeTToByteArray(map)

    @TypeConverter
    fun byteArrayToMapOfIntAndListOfString(byteArray: ByteArray): Map<Int, List<String>> = byteArrayToTypeT(byteArray)

//    @TypeConverter
//    fun mapOfIntAndStringToString(map: Map<Int, String>): String {
//        return map.toString()
//    }
//
//    @TypeConverter
//    fun stringToMapOfIntAndString(string: String): Map<Int, String> {
//        val listOfPair = string.substring(1, string.length).split(", ")
//        val answer : MutableMap<Int, String> = mutableMapOf()
//
//        listOfPair.forEach { pairString ->
//            val pair = stringToPairOfIntAndString(pairString)
//            answer[pair.first] = pair.second
//        }
//
//        return answer
//    }
//
//    /* 1=sf=sd"f should return 1 to "sf=sd\"f"*/
//    private fun stringToPairOfIntAndString(string: String): Pair<Int, String> {
//        var numberLastIndex = 0
//        val strSize = string.length
//
//        // Get the last index of the Int (key)
//        for(idx in 0 until strSize) {
//            if (string[idx] in '0'..'9') numberLastIndex++
//            else break
//        }
//
//        // Error Handling
//        if (strSize <= 0) throw Exception("Cannot parse the empty string.")
//        if (numberLastIndex == 0) throw Exception("No key in the given string.")
//        if (numberLastIndex >= strSize - 1) throw Exception("No value in the given string.")
//
//        // Parse the Int (key)
//        val key = string.substring(0, numberLastIndex).toInt()
//        val value = string.substring(numberLastIndex + 1, strSize)
//
//        return key to value
//    }
//    @TypeConverter
//    fun listOfVocabularyToString(list: List<Vocabulary>): String = list.toString()
//
//    @TypeConverter
//    fun stringToListOfVocabulary(string: String): List<Vocabulary> {
//        val listOfVocString = string.substring(1, string.length - 1)
//            .split(", V")
//
//        val listOfVoc = mutableListOf<Vocabulary>()
//
//        listOfVocString.forEach { str ->
//            listOfVoc.add(stringToVocabulary(str))
//        }
//
//        return listOfVoc
//    }
//
//    /** id=0, word=apple, chinese=APPLE, breakpoint=2 ->
//     * Vocabulary(id = 0, word = "apple", chinese = "APPLE", breakpoint = 2)*/
//    private fun stringToVocabulary(string: String): Vocabulary {
//        val idIndex = string.indexOf("id=")
//        val firstComma = string.indexOf(", w")
//        val secondComma = string.indexOf(", c", firstComma + 1)
//        val thirdComma = string.indexOf(", b", secondComma + 1)
//
////        Log.d("TypeConverter", string)
//
//        return Vocabulary(
//            id = string.substring(idIndex + 3, firstComma).toInt(),
//            word = string.substring(firstComma + 7, secondComma),
//            chinese = string.substring(secondComma + 10, thirdComma),
//            breakpoint = string.substring(thirdComma + 13, string.length - 1).toInt()
//        )
//    }


//    /**
//     * [VocabularyForTheme(id=0, word=lamp, chinese=檯燈, positionForClickButton=Coordinate(x=150.0, y=150.5)), VocabularyForTheme(id=1, word=lamp, chinese=檯燈, positionForClickButton=Coordinate(x=120.0, y=150.0))]
//     * */
//    @TypeConverter
//    fun listOfVocabularyForThemeToString(list: List<VocabularyForTheme>) : String  = list.toString()
//
//    @TypeConverter
//    fun stringToListOfVocabularyForTheme(string: String): List<VocabularyForTheme> {
//        val listOfString = string.substring(1, string.length - 1)
//            .split(", V")
//
//        val answer = mutableListOf<VocabularyForTheme>()
//        listOfString.forEach { str ->
//            answer.add(stringToVocabularyForTheme(str))
//        }
//        return answer
//    }
//
//    private fun stringToVocabularyForTheme(string: String): VocabularyForTheme {
//        val idIndex = string.indexOf("id=")
//        val firstComma = string.indexOf(", w")
//        val secondComma = string.indexOf(", c", firstComma + 1)
//        val thirdComma = string.indexOf(", p", secondComma + 1)
//
//        return VocabularyForTheme(
//            id = string.substring(idIndex + 3, firstComma).toInt(),
//            word = string.substring(firstComma + 7, secondComma),
//            chinese = string.substring(secondComma + 25, thirdComma),
//            positionForClickButton = stringToCoordinate(string.substring(thirdComma + 13, string.length - 1))
//        )
//    }
//
//    private fun stringToCoordinate(string: String): Coordinate {
//        val xIndex = string.indexOf("x=")
//        val yIndex = string.indexOf(", y=")
//
//        return Coordinate(
//            x = string.substring(xIndex + 2, yIndex).toFloat(),
//            y = string.substring(yIndex + 4, string.length - 1).toFloat()
//        )
//    }
}