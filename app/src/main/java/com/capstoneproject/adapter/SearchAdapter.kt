package com.capstoneproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.capstoneproject.R

class SearchAdapter(private var results: List<String>) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    // Remove the initialization of 'results' here since it's now provided via the constructor
    // private var results = listOf<String>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val resultTextView: TextView = itemView.findViewById(R.id.itemTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.resultTextView.text = results[position]
    }

    override fun getItemCount(): Int {
        return results.size
    }

    fun updateResults(newResults: List<String>) {
        results = newResults
        notifyDataSetChanged()
    }
}
