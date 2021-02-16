package com.uala.data

import com.uala.data.recipe.MealResponseData

interface RecipeRemote {

    suspend fun search(meal:String):List<MealResponseData>
}