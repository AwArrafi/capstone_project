package com.capstoneproject.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstoneproject.databinding.ItemCardBinding
import com.capstoneproject.model.FavouriteItem
import com.capstoneproject.ui.DetailActivity

class FavouriteAdapter(
    private val context: Context,
    private val items: List<FavouriteItem>,
    private val onItemClick: (FavouriteItem) -> Unit // Click listener passed as a parameter
) : RecyclerView.Adapter<FavouriteAdapter.FavouriteViewHolder>() {

    inner class FavouriteViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FavouriteItem) {
            binding.itemImage.setImageResource(item.imageResId)
            binding.itemTitle.text = item.title
            binding.itemDescription.text = item.description

            // Set up the click listener
            binding.root.setOnClickListener {
                // Passing the FavouriteItem via Intent to DetailActivity
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("favourite_item", item)  // Passing FavouriteItem
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(context), parent, false)
        return FavouriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavouriteViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}
