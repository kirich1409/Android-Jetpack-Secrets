@file:Suppress("RedundantOverride")

package com.kirich1409.talks.androidx.secrets.appcompat.content

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiric1409.talks.androidx.secrets.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class MainActivity1 :
    AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
