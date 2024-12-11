package com.capstoneproject.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstoneproject.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup ViewBinding
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil hasil dari intent
        val result = intent.getStringExtra("RESULT")
        binding.resultTextView.text = result

        // Setup tombol kembali
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}
