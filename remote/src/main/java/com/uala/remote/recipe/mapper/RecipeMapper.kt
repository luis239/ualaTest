package com.uala.remote.recipe.mapper

import com.uala.data.recipe.MealResponseData
import com.uala.remote.recipe.model.MealResponseRemote

fun MealResponseRemote.mapToData(): MealResponseData {
    return MealResponseData(
        strIngredient10,
        strIngredient12,
        strIngredient11,
        strIngredient14,
        strCategory,
        strIngredient13,
        strIngredient16,
        strIngredient15,
        strIngredient18,
        strIngredient17,
        strArea,
        strIngredient19,
        strTags,
        idMeal,
        strInstructions,
        strIngredient1,
        strIngredient3,
        strIngredient2,
        strIngredient20,
        strIngredient5,
        strIngredient4,
        strIngredient7,
        strIngredient6,
        strIngredient9,
        strIngredient8,
        strMealThumb,
        strMeasure20,
        strYoutube,
        strMeal,
        strMeasure12,
        strMeasure13,
        strMeasure10,
        strMeasure11,
        dateModified,
        strDrinkAlternate,
        strSource,
        strMeasure9,
        strMeasure7,
        strMeasure8,
        strMeasure5,
        strMeasure6,
        strMeasure3,
        strMeasure4,
        strMeasure1,
        strMeasure18,
        strMeasure2,
        strMeasure19,
        strMeasure16,
        strMeasure17,
        strMeasure14,
        strMeasure15
    )
}