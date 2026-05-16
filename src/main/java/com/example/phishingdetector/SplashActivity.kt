package com.example.phishingdetector

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 5000 milisaniye (5 saniye) bekleme süresi
        Handler(Looper.getMainLooper()).postDelayed({
            // Bekleme bitince asıl uygulamaya geçiş yap
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // Kullanıcı geri tuşuna basınca bu açılış ekranına dönmesin diye burayı kapatıyoruz
            finish()
        }, 5000)
    }
}