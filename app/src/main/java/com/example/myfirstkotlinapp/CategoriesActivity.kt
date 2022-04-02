package com.example.myfirstkotlinapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        var actionBar : ActionBar? = getSupportActionBar()
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val categories = arrayListOf<CategoryModel>(
            CategoryModel("Family", "What", "me", R.drawable.family),
            CategoryModel("Love", "The greatest happiness of life is the conviction that we are loved; loved for ourselves, or rather, loved in spite of ourselves.", "Victor Hugo", R.drawable.love),
            CategoryModel("Friends", "What", "me", R.drawable.friends),
            CategoryModel("Work", "What", "me", R.drawable.work)
        )

        val recyclerview = findViewById<RecyclerView>(R.id.categoriesView)
        recyclerview.layoutManager = GridLayoutManager(this, 2)
        var adapter = CategoriesAdapter(categories)
        recyclerview.adapter = adapter
        adapter.setOnCategoryClickListener(object : CategoriesAdapter.onCategoryClickListener{
            override fun onCategoryClick(position: Int) {
                val intent = Intent(applicationContext,QuoteActivity::class.java)
                intent.putExtra("quote",categories[position].quote)
                intent.putExtra("person",categories[position].person)
                intent.putExtra("icon",categories[position].icon)
                startActivity(intent)
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.getItemId()) {
            android.R.id.home -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}