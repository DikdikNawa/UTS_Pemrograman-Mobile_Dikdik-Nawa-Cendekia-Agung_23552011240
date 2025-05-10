package com.example.uts_pemrograman_mobile

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ChatAdapter(private val context: Context, private val chatList: List<Chat>) : BaseAdapter() {

    override fun getCount(): Int = chatList.size

    override fun getItem(position: Int): Any = chatList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val chat = getItem(position) as Chat

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.item_chat, null)

        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvLastMessage: TextView = view.findViewById(R.id.tvLastMessage)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
        val imgProfile: ImageView = view.findViewById(R.id.imgProfile)

        tvName.text = chat.name
        tvLastMessage.text = chat.lastMessage
        tvTime.text = chat.time
        imgProfile.setImageResource(chat.profileImage)

        return view
    }
}
