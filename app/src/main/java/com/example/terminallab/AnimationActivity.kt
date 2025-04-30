package com.example.terminallab

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AnimationActivity : AppCompatActivity() {
    private lateinit var anm: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animation)

        anm = findViewById(R.id.anm)
        anm.setBackgroundResource(R.drawable.animation)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val frameAnimation = anm.background as? AnimationDrawable
        frameAnimation?.let {
            if (hasFocus) {
                it.start()
            } else {
                it.stop()
            }
        }
    }

}