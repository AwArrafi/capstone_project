package com.capstoneproject.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.capstoneproject.databinding.ProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Handle Back Button
        binding.backButton.setOnClickListener {
            finish()
        }

        // Setup actions for each card
        binding.nameText.setOnClickListener {
            Toast.makeText(this, "Name clicked", Toast.LENGTH_SHORT).show()
        }

        binding.emailText.setOnClickListener {
            Toast.makeText(this, "Email clicked", Toast.LENGTH_SHORT).show()
        }

        binding.passwordText.setOnClickListener {
            Toast.makeText(this, "Password clicked", Toast.LENGTH_SHORT).show()
        }

        // Handle Logout Button
        binding.logoutButton.setOnClickListener {
            Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
        }
    }
}
