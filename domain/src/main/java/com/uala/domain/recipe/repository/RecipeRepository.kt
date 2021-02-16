package com.uala.domain.recipe.repository

import com.uala.domain.recipe.model.MealResponseModel

interface RecipeRepository {

    suspend fun search(meal:String):List<MealResponseModel>
}