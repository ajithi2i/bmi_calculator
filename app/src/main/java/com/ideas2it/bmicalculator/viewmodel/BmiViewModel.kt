package com.ideas2it.bmicalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ideas2it.bmicalculator.model.BmiCategory
import com.ideas2it.bmicalculator.model.BmiResult

class BmiViewModel : ViewModel() {
    private val _bmiResult = MutableLiveData<BmiResult>()
    val bmiResult: LiveData<BmiResult> = _bmiResult

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun calculateBmi(heightCm: String, weightKg: String) {
        if (heightCm.isBlank() || weightKg.isBlank()) {
            return
        }

        try {
            val height = heightCm.toDouble()
            val weight = weightKg.toDouble()

            if (height <= 0 || weight <= 0) {
                return
            }

            _isLoading.value = true

            // Convert height from cm to meters
            val heightInMeters = height / 100
            val bmi = weight / (heightInMeters * heightInMeters)
            
            val category = BmiCategory.fromBmi(bmi)
            val message = BmiCategory.getMessage(category)
            
            _bmiResult.value = BmiResult(bmi, category, message)
        } catch (e: NumberFormatException) {
            // Handle invalid input
        } finally {
            _isLoading.value = false
        }
    }

    fun resetBmi() {
        _bmiResult.value = null
    }
} 