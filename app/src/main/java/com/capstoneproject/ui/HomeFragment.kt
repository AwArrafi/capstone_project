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
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            startActivity(intent)
        }

        // OnClickListener to trigger SearchActivity
        binding.searchEditText.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
        }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
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
                description = "Cheesy and delicious pangsit.",
                imageRes = R.drawable.pangsit
            )
        )

        val adapter = RecommendationAdapter(recommendations) { recommendation ->
            // Navigasi ke DetailActivity
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra(
                    "menu_item",
                    com.capstoneproject.model.MenuItem(
                        imageResId = recommendation.imageRes,
                        title = recommendation.title,
                        description = recommendation.description
                    )
                )
            }
            startActivity(intent)
        }

        binding.recommendationRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.recommendationRecyclerView.adapter = adapter
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
