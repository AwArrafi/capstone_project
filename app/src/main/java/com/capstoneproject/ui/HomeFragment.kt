package com.capstoneproject.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstoneproject.R
import com.capstoneproject.RecommendationAdapter
import com.capstoneproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.helloText.text = getString(R.string.greetings)
        binding.searchSubtitle.text = getString(R.string.looking_something)

        // OnClickListener for profileButton
        binding.profileButton.setOnClickListener {
            // Action when profileButton is clicked (e.g., open user profile screen)
        }

        // OnClickListener to trigger SearchActivity
        binding.searchEditText.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Dummy data untuk rekomendasi
        val recommendations = listOf(
            RecommendationAdapter.RecommendationItem(
                title = "Telur",
                description = "Delicious egg with a tangy flavor.",
                imageRes = R.drawable.telur
            ),
            RecommendationAdapter.RecommendationItem(
                title = "Fruits",
                description = "Fresh and healthy fruits.",
                imageRes = R.drawable.fruits
            ),
            RecommendationAdapter.RecommendationItem(
                title = "Pangsit",
                description = "Cheesy and delicious pizza.",
                imageRes = R.drawable.pangsit
            )
        )

        // Atur RecyclerView dengan Horizontal LayoutManager
        val adapter = RecommendationAdapter(recommendations)
        binding.recommendationRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recommendationRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
