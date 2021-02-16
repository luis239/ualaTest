package com.uala.test.recipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.uala.domain.recipe.model.MealResponseModel
import com.uala.test.R
import com.uala.test.databinding.ActivityMealDetailsBinding

class MealDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMealDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val meal = intent?.extras?.getParcelable<MealResponseModel>(EXTRA_MEAL)
        binding.nameMeal.text = meal!!.strMeal
        binding.textContent.text = meal.strInstructions
        Glide.with(this)
            .load(meal.strMealThumb)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imgMeal)
    }

    companion object{
        const val EXTRA_MEAL = "meal"
    }
}