package com.capstoneproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecommendationAdapter(
    private val items: List<RecommendationItem>,
    private val onItemClick: (RecommendationItem) -> Unit // Callback untuk klik item
) : RecyclerView.Adapter<RecommendationAdapter.ViewHolder>() {

    data class RecommendationItem(
        val title: String,
        val description: String,
        val imageRes: Int
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.headerImage)
        val title: TextView = view.findViewById(R.id.cardTitle)
        val description: TextView = view.findViewById(R.id.cardDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommendation, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.description.text = item.description
        holder.image.setImageResource(item.imageRes)

        // Tambahkan listener klik
        holder.itemView.setOnClickListener {
            onItemClick(item) // Panggil callback saat item diklik
        }
    }

    override fun getItemCount(): Int = items.size
}
