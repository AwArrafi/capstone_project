package com.capstoneproject.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstoneproject.R
import com.capstoneproject.adapter.MenuAdapter
import com.capstoneproject.databinding.FragmentMenuBinding
import com.capstoneproject.model.MenuItem

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
            MenuItem(R.drawable.telur, "Eggs", "Freshly cooked eggs"),
            MenuItem(R.drawable.pangsit, "Dumplings", "Soft and crispy dumplings"),
            MenuItem(R.drawable.fruits, "Fruits", "Fresh and juicy fruits")
        )

        // Setup RecyclerView dengan Adapter dan listener klik
        binding.recyclerViewMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewMenu.adapter = MenuAdapter(menuItems) { menuItem ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("menu_item", menuItem)
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
