package com.example.uts_pemrograman_mobile

data class User(val Username : String, val password : String)

object UserStorage {
    val users = ArrayList<User>().apply {
        add(User("admin", "admin"))
    }
}