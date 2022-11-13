package com.example.massignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.massignment.databinding.ActivitySplashBinding

class splash : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.myLooper()!!).postDelayed({
             val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()

        },4500)
    }
}