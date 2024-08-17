package com.example.notesapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        startActivity(intent)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val handler = android.os.Handler()
        handler.postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },2000)





    }
}