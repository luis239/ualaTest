package com.uala.data.recipe

import com.uala.data.RecipeRemote
import com.uala.data.recipe.mapper.mapToModel
import com.uala.domain.recipe.model.MealResponseModel
import com.uala.domain.recipe.repository.RecipeRepository

class RecipeDataImpl(private val remote:RecipeRemote) :RecipeRepository{
    override suspend fun search(meal: String): List<MealResponseModel> {
        return remote.search(meal).map {
            it.mapToModel()
        }
    }
}