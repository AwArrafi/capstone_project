package com.capstoneproject.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstoneproject.R
import com.capstoneproject.adapter.SearchAdapter
import com.google.android.material.search.SearchView

class SearchActivity : AppCompatActivity() {

    private lateinit var searchView: SearchView
    private lateinit var menuRecyclerView: RecyclerView
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Initialize components
        searchView = findViewById(R.id.searchView)
        menuRecyclerView = findViewById(R.id.menuRecyclerView)

        // Setup RecyclerView
        val layoutManager = LinearLayoutManager(this)
        menuRecyclerView.layoutManager = layoutManager

        // Setup adapter
        searchAdapter = SearchAdapter(getDefaultMenuItems()) // Initialize with default menu items
        menuRecyclerView.adapter = searchAdapter

        // Add TextWatcher to detect changes in search input
        searchView.getEditText()?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                // Not necessary to implement here
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                // Update results based on user input
                if (!charSequence.isNullOrEmpty()) {
                    val filteredResults = searchMenuItems(charSequence.toString())
                    searchAdapter.updateResults(filteredResults) // Show search results
                } else {
                    searchAdapter.updateResults(getDefaultMenuItems()) // Show default menu items
                }
            }

            override fun afterTextChanged(editable: Editable?) {
                // Not necessary to implement here
            }
        })

        // Handle "Enter" press on the keyboard to confirm search
        searchView.getEditText()?.setOnEditorActionListener { v, actionId, event ->
            // When "Enter" is pressed, display the query in a Toast or perform search action
            Toast.makeText(this@SearchActivity, "Search submitted: ${searchView.getEditText()?.text}", Toast.LENGTH_SHORT).show()

            // Hide SearchView after submission
            searchView.hide()
            false
        }
    }

    // Function to get default menu items (dummy data for now)
    private fun getDefaultMenuItems(): List<String> {
        return listOf("Menu 1", "Menu 2", "Menu 3", "Menu 4", "Menu 5")
    }

    // Function to search menu items based on query
    private fun searchMenuItems(query: String): List<String> {
        val allMenuItems = getDefaultMenuItems()
        return allMenuItems.filter { it.contains(query, ignoreCase = true) }
    }
}
