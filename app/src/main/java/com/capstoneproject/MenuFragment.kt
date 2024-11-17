package com.capstoneproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstoneproject.adapter.MenuAdapter
import com.capstoneproject.adapter.MenuItem
import com.capstoneproject.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data untuk menu
        val menuItems = listOf(
            MenuItem(R.drawable.telur, "Telur", "Telur segar dari peternakan"),
            MenuItem(R.drawable.pangsit, "Pangsit", "Pangsit renyah dengan isian ayam"),
            MenuItem(R.drawable.fruits, "Buah-buahan", "Buah segar untuk kebutuhan sehari-hari")
        )

        // Setup RecyclerView
        binding.recyclerViewMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewMenu.adapter = MenuAdapter(menuItems)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
