# 🛡️ Türkçe SMS ve Oltalama (Phishing) Tespiti Mobil Entegrasyonu

[![Durum](https://img.shields.io/badge/DURUM-TAMAMLANDI-007ec6?style=for-the-badge&labelColor=555555)](#)
[![Versiyon](https://img.shields.io/badge/VERSİYON-V1.0.0-brightgreen?style=for-the-badge)](#)
[![Platform](https://img.shields.io/badge/PLATFORM-ANDROID-orange?style=for-the-badge)](#)

Bu proje, Türkçe dil yapısına özgü veri setleri kullanılarak eğitilmiş bir Doğal Dil İşleme (NLP) ve makine öğrenmesi modelinin, native bir Android uygulamasına (Kotlin) entegre edilmesini sağlayan uçtan uca bir siber güvenlik çözümüdür.

Bu proje, Türkçe dil yapısına özgü veri setleri kullanılarak eğitilmiş bir Doğal Dil İşleme (NLP) ve makine öğrenmesi modelinin, native bir Android uygulamasına (Kotlin) entegre edilmesini amaçlayan uçtan uca bir yapay zeka/mobil çözümüdür.

### 🎯 Mimari ve Özellikler
* **Veri İşleme ve Model Eğitimi (NLP):** Türkçe SMS ve metin veri setleri üzerinde metin ön işleme (tokenization, stop-word temizleme) yapılıp, zararlı/oltalama (phishing) içeriklerini tespit edecek makine öğrenmesi modelinin eğitilmesi.
* **Mobil Entegrasyon:** Eğitilen modelin dışa aktarılarak cihaz üzerinde (on-device) veya API aracılığıyla çalışacak şekilde Kotlin tabanlı bir Android uygulamasına gömülmesi.
* **Gerçek Zamanlı Analiz:** Kullanıcının şüphelendiği metinleri uygulamaya girerek anında "Güvenli" veya "Tehlikeli" şeklinde skorlama alabilmesi.

### 🛠️ Kullanılan Teknolojiler
* **Yapay Zeka & Backend:** Python, Scikit-Learn / TensorFlow, Pandas, NLTK
* **Mobil Geliştirme:** Kotlin, Android SDK
