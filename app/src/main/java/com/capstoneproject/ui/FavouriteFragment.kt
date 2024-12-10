package com.capstoneproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstoneproject.R
import com.capstoneproject.adapter.FavouriteAdapter
import com.capstoneproject.adapter.FavouriteItem
import com.capstoneproject.databinding.FragmentFavouriteBinding

class FavouriteFragment : Fragment() {

    private var _binding: FragmentFavouriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data untuk favourite
        val favouriteItems = listOf(
            FavouriteItem(R.drawable.telur, "Telur", "Telur segar dari peternakan"),
            FavouriteItem(R.drawable.pangsit, "Pangsit", "Pangsit renyah dengan isian ayam"),
            FavouriteItem(R.drawable.fruits, "Buah-buahan", "Buah segar untuk kebutuhan sehari-hari")
        )

        // Setup RecyclerView
        binding.recyclerViewFavorite.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFavorite.adapter = FavouriteAdapter(favouriteItems)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}