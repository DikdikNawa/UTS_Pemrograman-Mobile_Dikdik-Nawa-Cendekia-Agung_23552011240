package com.example.uts_pemrograman_mobile

import android.os.Bundle
import android.view.WindowManager
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ListChattingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_list_chatting)

        val listViewChats: ListView = findViewById(R.id.listViewChats)

        val chatList = mutableListOf(
            Chat("Menhera", "Hallo!", "14:32", R.drawable.anime_ok),
            Chat("Kuro", "Kapan Main Genshin lagi bang?", "13:45", R.drawable.kazuha),
            Chat("Frieren", "Let's meet up!", "12:50", R.drawable.frieren)
        )

        val chatAdapter = ChatAdapter(this, chatList)
        listViewChats.adapter = chatAdapter

        listViewChats.setOnItemClickListener { _, _, position, _ ->
            val selectedChat = chatList[position]
            Toast.makeText(this, "Chat dengan ${selectedChat.name}", Toast.LENGTH_SHORT).show()
        }
    }
}
