package com.example.uts_pemrograman_mobile

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(R.layout.activity_register)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextConfirmPassword = findViewById<EditText>(R.id.editTextConfirmPassword)
        val togglePassword = findViewById<ImageView>(R.id.togglePassword)
        val toggleConfirmPassword = findViewById<ImageView>(R.id.toggleConfirmPassword)
        val btnSignUp = findViewById<Button>(R.id.btnSignUp)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        var isPasswordVisible = false
        var isConfirmPasswordVisible = false

        togglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                editTextPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                togglePassword.setImageResource(R.drawable.eyepass_white)
            } else {
                editTextPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                togglePassword.setImageResource(R.drawable.eyepass_white)
            }
            editTextPassword.setSelection(editTextPassword.text.length)
        }

        toggleConfirmPassword.setOnClickListener {
            isConfirmPasswordVisible = !isConfirmPasswordVisible
            if (isConfirmPasswordVisible) {
                editTextConfirmPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                toggleConfirmPassword.setImageResource(R.drawable.eyepass_white)
            } else {
                editTextConfirmPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                toggleConfirmPassword.setImageResource(R.drawable.eyepass_white)
            }
            editTextConfirmPassword.setSelection(editTextConfirmPassword.text.length)
        }

        btnSignUp.setOnClickListener {
            val Username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val confirmPassword = editTextConfirmPassword.text.toString()

            if (password == confirmPassword) {
                UserStorage.users.add(User(Username, password))
                Toast.makeText(this, "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom)
                finish()
            } else {
                Toast.makeText(this, "Password tidak sesuai", Toast.LENGTH_SHORT).show()
            }
        }

        btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom)
        }
    }
}
