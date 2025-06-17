package com.ideas2it.bmicalculator.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ideas2it.bmicalculator.model.BmiCategory
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class BmiViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BmiViewModel

    @Before
    fun setup() {
        viewModel = BmiViewModel()
    }

    @Test
    fun `calculate BMI for normal weight category`() {
        // Height: 170cm, Weight: 65kg
        viewModel.calculateBmi("170", "65")
        
        val result = viewModel.bmiResult.value
        assertEquals(22.5, result?.bmi, 0.1)
        assertEquals(BmiCategory.NORMAL, result?.category)
    }

    @Test
    fun `calculate BMI for underweight category`() {
        // Height: 170cm, Weight: 50kg
        viewModel.calculateBmi("170", "50")
        
        val result = viewModel.bmiResult.value
        assertEquals(17.3, result?.bmi, 0.1)
        assertEquals(BmiCategory.UNDERWEIGHT, result?.category)
    }

    @Test
    fun `calculate BMI for overweight category`() {
        // Height: 170cm, Weight: 80kg
        viewModel.calculateBmi("170", "80")
        
        val result = viewModel.bmiResult.value
        assertEquals(27.7, result?.bmi, 0.1)
        assertEquals(BmiCategory.OVERWEIGHT, result?.category)
    }

    @Test
    fun `calculate BMI for obese category`() {
        // Height: 170cm, Weight: 100kg
        viewModel.calculateBmi("170", "100")
        
        val result = viewModel.bmiResult.value
        assertEquals(34.6, result?.bmi, 0.1)
        assertEquals(BmiCategory.OBESE, result?.category)
    }

    @Test
    fun `handle invalid input`() {
        viewModel.calculateBmi("invalid", "65")
        assertNull(viewModel.bmiResult.value)
    }

    @Test
    fun `handle zero values`() {
        viewModel.calculateBmi("0", "65")
        assertNull(viewModel.bmiResult.value)
    }

    @Test
    fun `handle negative values`() {
        viewModel.calculateBmi("-170", "65")
        assertNull(viewModel.bmiResult.value)
    }

    @Test
    fun `reset BMI clears result`() {
        viewModel.calculateBmi("170", "65")
        viewModel.resetBmi()
        assertNull(viewModel.bmiResult.value)
    }
} 