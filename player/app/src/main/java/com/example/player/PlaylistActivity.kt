package com.example.player

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class PlaylistActivity : AppCompatActivity() {
    private val playlists = ArrayList<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.player.R.layout.activity_playlist)

        val listView = findViewById<ListView>(com.example.player.R.id.listPlaylists)
        val btnAdd = findViewById<Button>(com.example.player.R.id.btnAddPlaylist)

        adapter = ArrayAdapter(this, com.example.player.R.layout.item_playlist, com.example.player.R.id.tvPlaylistName, playlists)
        listView.adapter = adapter

        btnAdd.setOnClickListener {
            val input = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("Новый плейлист")
                .setView(input)
                .setPositiveButton("Создать") { _, _ ->
                    val name = input.text.toString()
                    if (name.isNotEmpty()) {
                        playlists.add(name)
                        adapter.notifyDataSetChanged()
                    }
                }
                .setNegativeButton("Отмена", null)
                .show()
        }
    }
}
