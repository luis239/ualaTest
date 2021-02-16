package com.uala.remote.recipe.model

import com.squareup.moshi.Json

data class SearchResponseRemote(
    @Json(name = "meals")
    val meals: List<MealResponseRemote>

)