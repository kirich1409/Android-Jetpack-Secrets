@file:Suppress("UNUSED_PARAMETER", "MemberVisibilityCanBePrivate", "unused")

package com.kirich1409.talks.androidx.secrets.appcompat.activityresult.simple

import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts.TakePicture
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    var pictureUri: Uri? = null

    val takePhoto = registerForActivityResult(TakePicture()) { isImageSaved ->
        val pictureUri = pictureUri ?: return@registerForActivityResult
        onPictureTaken(pictureUri, isImageSaved)
        this.pictureUri = null
    }

    fun onPictureTaken(uri: Uri, isImageSaved: Boolean) {
        // Process the image
    }

    fun takePicture() {
        val pictureUri: Uri = Uri.fromFile(
            File.createTempFile("androidx-secrets", System.currentTimeMillis().toString())
        )
        this.pictureUri = pictureUri
        takePhoto.launch(pictureUri)
    }
}
