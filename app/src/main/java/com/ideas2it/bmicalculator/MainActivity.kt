package com.ideas2it.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ideas2it.bmicalculator.databinding.ActivityMainBinding
import com.ideas2it.bmicalculator.model.BmiCategory
import com.ideas2it.bmicalculator.viewmodel.BmiViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: BmiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
        observeViewModel()
    }

    private fun setupClickListeners() {
        binding.calculateButton.setOnClickListener {
            val height = binding.heightInput.text.toString()
            val weight = binding.weightInput.text.toString()

            if (height.isBlank() || weight.isBlank()) {
                Toast.makeText(this, "Please enter both height and weight", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.calculateBmi(height, weight)
        }

        binding.resetButton.setOnClickListener {
            binding.heightInput.text?.clear()
            binding.weightInput.text?.clear()
            viewModel.resetBmi()
            binding.resultCard.visibility = View.GONE
        }
    }

    private fun observeViewModel() {
        viewModel.bmiResult.observe(this) { result ->
            result?.let {
                binding.resultCard.visibility = View.VISIBLE
                binding.bmiValueText.text = "BMI: %.1f".format(it.bmi)
                binding.bmiCategoryText.text = "Category: ${it.category.name}"
                binding.bmiMessageText.text = it.message

                // Set card background color based on BMI category
                val colorResId = BmiCategory.getColorResId(it.category)
                binding.resultCard.setCardBackgroundColor(ContextCompat.getColor(this, colorResId))
            }
        }

        viewModel.isLoading.observe(this) { isLoading ->
            binding.loadingAnimation.visibility = if (isLoading) View.VISIBLE else View.GONE
        }
    }
}