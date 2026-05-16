package com.example.phishingdetector

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ai.onnxruntime.OnnxTensor
import ai.onnxruntime.OrtEnvironment
import ai.onnxruntime.OrtSession

class MainActivity : AppCompatActivity() {

    // ONNX Çalışma ortamı ve oturumu
    private var ortEnv: OrtEnvironment? = null
    private var ortSession: OrtSession? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Yeni profesyonel tasarımı set ediyoruz
        setContentView(R.layout.activity_main)

        // UI Elemanlarını Yeni ID'ler ile eşleştiriyoruz
        val mesajInput = findViewById<EditText>(R.id.mesajInput)
        val analizButonu = findViewById<Button>(R.id.analizButonu)
        val sonucText = findViewById<TextView>(R.id.sonucText)

        // 1. ADIM: Yapay Zeka Motorunu Başlat
        try {
            ortEnv = OrtEnvironment.getEnvironment()
            val modelBytes = assets.open("phishing_model.onnx").readBytes()
            ortSession = ortEnv?.createSession(modelBytes)
        } catch (e: Exception) {
            sonucText.text = "SİSTEM HATASI: Motor yüklenemedi!"
            sonucText.setTextColor(Color.parseColor("#EF4444")) // Modern Kırmızı
        }

        analizButonu.setOnClickListener {
            val mesaj = mesajInput.text.toString().trim()

            if (mesaj.isEmpty()) {
                sonucText.text = "Lütfen analiz için bir veri girin..."
                sonucText.setTextColor(Color.parseColor("#94A3B8")) // Slate Gray
                return@setOnClickListener
            }

            // Görsel geri bildirim (Analiz süreci simülasyonu)
            sonucText.text = "🔍 Nöral Ağlar Taranıyor..."
            sonucText.setTextColor(Color.WHITE)

            try {
                // 2. ADIM: Veriyi Yapay Zekaya Hazırla
                val inputTensor = OnnxTensor.createTensor(ortEnv, arrayOf(arrayOf(mesaj)))
                val inputs = mapOf("mesaj_girisi" to inputTensor)

                // 3. ADIM: Tahmin Yürüt
                val results = ortSession?.run(inputs)
                val tahmin = (results?.get(0)?.value as Array<*>)[0].toString()

                // 4. ADIM: Profesyonel Sonuç Ekranı
                if (tahmin == "Spam") {
                    // Siber Güvenlik Alarmı (Koyu Kırmızı Vurgu)
                    sonucText.text = "⚠️ KRİTİK RİSK: Oltalama (Phishing) Tespit Edildi!"
                    sonucText.setTextColor(Color.parseColor("#F87171")) // Yumuşak Kırmızı (Göz yormaz ama uyarır)
                } else {
                    // Güvenlik Onayı (Emerald Yeşili)
                    sonucText.text = "🛡️ GÜVENLİ: Herhangi bir tehdit bulunamadı."
                    sonucText.setTextColor(Color.parseColor("#34D399")) // Modern Yeşil
                }

                // Bellek Yönetimi
                inputTensor.close()
                results?.close()

            } catch (e: Exception) {
                sonucText.text = "ANALİZ HATASI: Veri işlenemedi."
                sonucText.setTextColor(Color.parseColor("#EF4444"))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ortSession?.close()
        ortEnv?.close()
    }
}