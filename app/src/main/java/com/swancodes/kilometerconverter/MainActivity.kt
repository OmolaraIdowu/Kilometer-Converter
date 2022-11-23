package com.swancodes.kilometerconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.swancodes.kilometerconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mileUnit = 0.62137119

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kilometer = binding.editText.text

        binding.convertButton.setOnClickListener {
            val result = calculateMiles(kilometer.toString().toDouble())
            if (kilometer.isEmpty()) {
                result.toString()
            } else {
                binding.resultText.text = "Enter kilometer"
            }
            binding.resultText.text = kilometer.toString() + " kilometer makes " + result.toString() + " miles"
        }
    }

    private fun calculateMiles(userInput: Double): Double {
        return userInput * mileUnit
    }
}