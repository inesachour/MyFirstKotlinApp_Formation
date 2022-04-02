package com.example.myfirstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import android.content.Intent
import android.view.MenuItem


class QuoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        var actionBar : ActionBar? = getSupportActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)

        var quoteView = findViewById<TextView>(R.id.quoteView)
        var personView = findViewById<TextView>(R.id.personView)
        var iconView = findViewById<ImageView>(R.id.icon)

        quoteView.text = "`${intent.getStringExtra("quote")}`"
        personView.text = "~ ${intent.getStringExtra("person")} ~"
        iconView.setImageResource(intent.getIntExtra("icon",R.drawable.work))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            android.R.id.home -> {
                val intent = Intent(this, CategoriesActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}