@file:Suppress(
    "UNUSED_PARAMETER", "MemberVisibilityCanBePrivate", "unused",
    "ControlFlowWithEmptyBody"
)

package com.kirich1409.talks.androidx.secrets.appcompat.activityresult.permissions

import android.Manifest
import android.annotation.SuppressLint
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.annotation.RequiresPermission
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingPermission")
    val requestPermissionForTrackUserResult =
        registerForActivityResult(RequestPermission()) { permissionGranted ->
            if (permissionGranted) {
                trackUser()
            }
        }

    @RequiresPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    fun trackUser() {
        // Start track user
    }

    fun requestPermissionForTrackUser() {
        requestPermissionForTrackUserResult.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}
