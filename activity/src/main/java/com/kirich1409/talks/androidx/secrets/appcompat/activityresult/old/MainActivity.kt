@file:Suppress("UNUSED_PARAMETER", "MemberVisibilityCanBePrivate", "unused", "DEPRECATION")

package com.kirich1409.talks.androidx.secrets.appcompat.activityresult.old

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    var pictureUri: Uri? = null

    fun onPictureTaken(uri: Uri, isImageSaved: Boolean) {
        // Process the image
    }

    fun takePicture() {
        val pictureUri: Uri = Uri.fromFile(
            File.createTempFile("androidx-secrets", System.currentTimeMillis().toString())
        )
        this.pictureUri = pictureUri
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            putExtra(MediaStore.EXTRA_OUTPUT, pictureUri)
        }
        startActivityForResult(intent, REQUEST_CODE_TAKE_PHOTO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_TAKE_PHOTO && intent != null) {
            onPictureTaken(checkNotNull(pictureUri), resultCode == Activity.RESULT_OK)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private companion object {

        private const val REQUEST_CODE_TAKE_PHOTO = 1
    }
}
