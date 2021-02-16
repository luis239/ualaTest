package com.uala.remote.recipe

import com.uala.data.RecipeRemote
import com.uala.data.recipe.MealResponseData
import com.uala.remote.ApiUlala
import com.uala.remote.recipe.mapper.mapToData

class RecipeRemoteImpl(private val service:ApiUlala):RecipeRemote {
    override suspend fun search(meal: String): List<MealResponseData>{
        val mealsList =  service.search(meal).body()!!
        return mealsList.meals.map {
            it.mapToData()
        }
    }
}