package com.example.finalprojecttemplate.ui.homepage

import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load
import com.example.finalprojecttemplate.R

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: Uri?) {
    imgUrl?.let {
        // Load the image in the background using Coil.
        val imgUri = imgUrl.buildUpon().scheme("https").build()
        imgView.load(imgUri) {
            placeholder(R.drawable.trademark_image)
            error(R.drawable.trademark_image)
        }
    }
}