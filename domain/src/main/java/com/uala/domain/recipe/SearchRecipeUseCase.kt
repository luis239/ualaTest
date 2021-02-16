package com.uala.domain.recipe

import com.uala.domain.Failure
import com.uala.domain.BaseUseCase
import com.uala.domain.Either
import com.uala.domain.recipe.model.MealResponseModel
import com.uala.domain.recipe.repository.RecipeRepository

class SearchRecipeUseCase (private val recipeRepository: RecipeRepository):
    BaseUseCase<List<MealResponseModel>, SearchRecipeUseCase.Params>() {
    override suspend fun run(params: Params): Either<Failure, List<MealResponseModel>> {
        return try {
            val response = recipeRepository.search(params.meal)
            Either.Right(response)

        } catch (e: Exception) {
            Either.Left(SearchFailure(e))
        }
    }

    data class Params(val meal: String)

    data class SearchFailure(val error: Exception) : Failure.FeatureFailure(error)
}