package com.example.myfirstkotlinapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(private val categories: List<CategoryModel>) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private lateinit var listener: onCategoryClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view,listener)
    }

    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {
        val items = categories[position]
        holder.imageView.setImageResource(items.icon)
        holder.textView.text = items.text
    }

    override fun getItemCount(): Int {
        return categories.size;
    }

    inner class ViewHolder(ItemView: View, listener: onCategoryClickListener) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.categoryIcon)
        val textView: TextView = itemView.findViewById(R.id.categoryName)

        init {
            itemView.setOnClickListener{
                listener.onCategoryClick(adapterPosition)
            }
        }
    }

    public interface onCategoryClickListener{
        fun onCategoryClick(position: Int)
    }

    fun setOnCategoryClickListener(mlistener: onCategoryClickListener){
        listener = mlistener
    }
}