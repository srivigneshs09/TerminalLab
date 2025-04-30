package com.example.terminallab

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MediaActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media)

        val imageView: ImageView = findViewById(R.id.imageView)
        val playAudioButton: Button = findViewById(R.id.playAudioButton)
        val stopAudioButton: Button = findViewById(R.id.stopAudioButton)
        val playVideoButton: Button = findViewById(R.id.playVideoButton)
        val stopVideoButton: Button = findViewById(R.id.stopVideoButton)
        videoView = findViewById(R.id.videoView)

        imageView.setImageResource(R.drawable.ic_launcher_background)

        mediaPlayer = MediaPlayer.create(this, R.raw.song)

        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.sample}")
        videoView.setVideoURI(videoUri)

        playAudioButton.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }

        stopAudioButton.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
        }

        playVideoButton.setOnClickListener {
            if (!videoView.isPlaying) {
                videoView.start()
            }
        }

        stopVideoButton.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause()
                videoView.seekTo(0)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
        if (videoView.isPlaying) {
            videoView.pause()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}