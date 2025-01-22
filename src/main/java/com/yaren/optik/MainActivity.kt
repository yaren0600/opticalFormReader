package com.yaren.optik

import android.app.Activity
import android.app.ActivityManager
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yaren.optik.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var preferences : SharedPreferences

    lateinit var username : EditText
    lateinit var password : EditText
    lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        preferences = getSharedPreferences("bilgiler", MODE_PRIVATE)// bilgiler dosyasına erişimi sağlar
        //    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        //    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //  insets
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener({

            var kayitliKullanici = preferences.getString("kullanici","")
            var kayitliSifre = preferences.getString("sifre", "")

            var girisKullanici = binding.girisKullaniciad.text.toString()
            var girisSifre = binding.girisSifre.text.toString()

            if((kayitliKullanici == girisKullanici) && (kayitliSifre == girisSifre)){
                intent = Intent(applicationContext,MainHosgeldiniz::class.java)
                startActivity(intent)
            }


            else{
                Toast.makeText(this,"Kullanıcı Adı veya Şifre Hatalı!!!",Toast.LENGTH_SHORT).show()
            }



        })

        binding.kayitButton.setOnClickListener({
            intent = Intent(applicationContext,MainKayitOl::class.java)
            startActivity(intent)
        })
    }
}