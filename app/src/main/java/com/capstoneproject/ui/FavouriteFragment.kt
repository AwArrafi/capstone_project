package com.capstoneproject.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstoneproject.R
import com.capstoneproject.adapter.FavouriteAdapter
import com.capstoneproject.model.FavouriteItem
import com.capstoneproject.databinding.FragmentFavouriteBinding
import com.capstoneproject.ui.DetailActivity

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
            FavouriteItem(R.drawable.telur, "Eggs", "Freshly cooked eggs"),
            FavouriteItem(R.drawable.pangsit, "Dumplings", "Soft and crispy dumplings"),
            FavouriteItem(R.drawable.fruits, "Fruits", "Fresh and juicy fruits")
        )

        // Setup RecyclerView dengan adapter
        binding.recyclerViewFavorite.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFavorite.adapter = FavouriteAdapter(requireContext(), favouriteItems) { favouriteItem ->
            // Click listener: Navigate to DetailActivity and pass the FavouriteItem
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("favourite_item", favouriteItem)
            startActivity(intent)
        }

        binding.profileButton.setOnClickListener {
            val intent = Intent(requireContext(), ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
