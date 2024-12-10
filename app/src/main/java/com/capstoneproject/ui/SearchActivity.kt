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
    private lateinit var resultsRecyclerView: RecyclerView
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Initialize components
        searchView = findViewById(R.id.searchView)
        resultsRecyclerView = findViewById(R.id.resultsRecyclerView)

        // Setup RecyclerView
        val layoutManager = LinearLayoutManager(this)
        resultsRecyclerView.layoutManager = layoutManager

        // Setup adapter for search results (dummy data example)
        searchAdapter = SearchAdapter()
        resultsRecyclerView.adapter = searchAdapter

        // Add TextWatcher to detect changes in search input
        searchView.getEditText()?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                // Not necessary to implement here
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                // Update results based on user input
                if (!charSequence.isNullOrEmpty()) {
                    // Example: search and display results (dummy data or data from DB)
                    searchAdapter.updateResults(listOf("Item 1", "Item 2", "Item 3"))
                } else {
                    searchAdapter.updateResults(emptyList()) // Clear results when search is empty
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
}
