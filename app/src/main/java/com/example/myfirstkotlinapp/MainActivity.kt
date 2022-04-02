package com.example.myfirstkotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToChatBtn = findViewById<Button>(R.id.goToChatBtn)

        goToChatBtn.setOnClickListener{
            val intent = Intent(this,CategoriesActivity::class.java)
            startActivity(intent)
        }
    }
}