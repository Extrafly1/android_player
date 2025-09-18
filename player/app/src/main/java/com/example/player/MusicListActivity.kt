package com.example.player

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MusicListActivity : AppCompatActivity() {
    private val songs = arrayOf("song1.mp3", "song2.mp3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.player.R.layout.activity_music_list)

        val listView = findViewById<ListView>(com.example.player.R.id.listMusic)
        val adapter = ArrayAdapter(this, com.example.player.R.layout.item_song, com.example.player.R.id.tvSongName, songs)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, PlayerActivity::class.java)
            intent.putExtra("song", songs[position])
            startActivity(intent)
        }
    }
}
