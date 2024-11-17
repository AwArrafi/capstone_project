package com.capstoneproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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

        // Set teks header
        binding.helloText.text = getString(R.string.greetings)
        binding.searchSubtitle.text = getString(R.string.looking_something)

        // Tombol profil
        binding.profileButton.setOnClickListener {
            // Tambahkan aksi ketika tombol profil diklik
        }

        // Setup RecyclerView untuk rekomendasi harian
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val recommendations = listOf("Item 1", "Item 2", "Item 3") // Data dummy
        val adapter = RecommendationAdapter(recommendations)
        binding.recommendationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recommendationRecyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
