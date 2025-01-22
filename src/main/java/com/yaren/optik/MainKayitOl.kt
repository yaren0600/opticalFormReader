package com.yaren.optik

import android.app.backup.SharedPreferencesBackupHelper
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yaren.optik.databinding.ActivityMainKayitOlBinding

class MainKayitOl : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainKayitOlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnKaydet.setOnClickListener {
            var kullaniciBilgisi = binding.kayitKullaniciadi.text.toString()
            var kullaniciSifre = binding.kayitSifre.text.toString()

            var SharedPreferences = this.getSharedPreferences("bilgiler", MODE_PRIVATE)
            //şimdilik veritabanı bağlantımız olmadığı için bir dosya oluşturup bilgileri buna kaydediyoruz
            var editor = SharedPreferences.edit()// veri ekleme silme işlemi için editör oluşturduk

            // veri ekleme
            editor.putString("kullanici","$kullaniciBilgisi").apply()
            editor.putString("sifre","$kullaniciSifre").apply()
            Toast.makeText(applicationContext, "Kayıt Başarılı", Toast.LENGTH_LONG).show()
            binding.kayitKullaniciadi.text.clear()
            binding.kayitSifre.text.clear()


        }


        binding.btnGiriseDon.setOnClickListener({
            intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        })

    }
}