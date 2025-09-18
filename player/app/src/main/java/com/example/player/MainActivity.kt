package com.example.player

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.player.R.layout.activity_main)

        val btnMusic = findViewById<Button>(com.example.player.R.id.btnMusic)
        val btnPlaylists = findViewById<Button>(com.example.player.R.id.btnPlaylists)

        btnMusic.setOnClickListener {
            startActivity(Intent(this, MusicListActivity::class.java))
        }

        btnPlaylists.setOnClickListener {
            startActivity(Intent(this, PlaylistActivity::class.java))
        }
    }
}
