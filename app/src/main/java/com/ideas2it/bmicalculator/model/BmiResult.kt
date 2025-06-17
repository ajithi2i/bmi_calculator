package com.ideas2it.bmicalculator.model

data class BmiResult(
    val bmi: Double,
    val category: BmiCategory,
    val message: String
)

enum class BmiCategory {
    UNDERWEIGHT,
    NORMAL,
    OVERWEIGHT,
    OBESE;

    companion object {
        fun fromBmi(bmi: Double): BmiCategory {
            return when {
                bmi < 18.5 -> UNDERWEIGHT
                bmi < 25 -> NORMAL
                bmi < 30 -> OVERWEIGHT
                else -> OBESE
            }
        }

        fun getMessage(category: BmiCategory): String {
            return when (category) {
                UNDERWEIGHT -> "You are underweight. Consider consulting a nutritionist."
                NORMAL -> "Your weight is normal. Keep maintaining a healthy lifestyle!"
                OVERWEIGHT -> "You are overweight. Consider starting a fitness routine."
                OBESE -> "You are in the obese category. Please consult a healthcare provider."
            }
        }

        fun getColorResId(category: BmiCategory): Int {
            return when (category) {
                UNDERWEIGHT -> android.R.color.holo_blue_light
                NORMAL -> android.R.color.holo_green_light
                OVERWEIGHT -> android.R.color.holo_orange_light
                OBESE -> android.R.color.holo_red_light
            }
        }
    }
} 