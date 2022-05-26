package com.hamedrahimvand.flipcard.model

import java.io.Serializable

/**
 *
 *@author Hamed.Rahimvand
 *@since 2020-02-22
 */
data class FlipModel(var id:Int,var name:String, var front:String, var back: String, var isFlipped: Boolean) : Serializable