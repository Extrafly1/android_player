package com.example.player

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.R

class PlayerActivity : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.player.R.layout.activity_player)

        tvTitle = findViewById(com.example.player.R.id.tvSongTitle)
        seekBar = findViewById(com.example.player.R.id.seekBar)
        val btnPlay = findViewById<Button>(com.example.player.R.id.btnPlay)
        val btnPause = findViewById<Button>(com.example.player.R.id.btnPause)
        val btnStop = findViewById<Button>(com.example.player.R.id.btnStop)

        val song = intent.getStringExtra("song")
        tvTitle.text = song

        val resId = resources.getIdentifier(song?.replace(".mp3", ""), "raw", packageName)
        mediaPlayer = MediaPlayer.create(this, resId)

        btnPlay.setOnClickListener {
            if (mediaPlayer?.isPlaying == false) mediaPlayer?.start()
        }

        btnPause.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) mediaPlayer?.pause()
        }

        btnStop.setOnClickListener {
            if (mediaPlayer?.isPlaying == true) {
                mediaPlayer?.stop()
                mediaPlayer = MediaPlayer.create(this, resId)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
