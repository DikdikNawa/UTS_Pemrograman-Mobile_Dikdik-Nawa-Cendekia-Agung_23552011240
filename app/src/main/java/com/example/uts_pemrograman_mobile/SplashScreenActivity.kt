package com.example.uts_pemrograman_mobile

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen) // Pastikan layout ini sesuai dengan yang sudah kamu buat

        // Delay selama 2 detik sebelum berpindah ke LoginActivity
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, LoginActivity::class.java) // Ganti dengan LoginActivity atau activity yang kamu tuju
            startActivity(intent)
            finish() // Tutup SplashScreen agar tidak kembali ke SplashScreen saat tombol back ditekan
        }, 2000) // Delay 2 detik
    }
}
