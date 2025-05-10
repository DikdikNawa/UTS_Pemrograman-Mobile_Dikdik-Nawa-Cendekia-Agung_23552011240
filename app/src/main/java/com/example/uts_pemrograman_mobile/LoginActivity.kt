package com.example.uts_pemrograman_mobile

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Fullscreen: sembunyikan status bar & navigation bar transparan
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE

        window.navigationBarColor = Color.TRANSPARENT
        window.statusBarColor = Color.TRANSPARENT

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)

        btnLogin.setOnClickListener {
            val Username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            val user = UserStorage.users.find { it.Username == Username && it.password == password }
            if (user != null) {
                val intent = Intent(this, ListChattingActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom)
                finish()
            } else {
                Toast.makeText(this, "Email atau password salah", Toast.LENGTH_SHORT).show()
            }
        }

        btnSignUp.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom)
        }
    }
}
