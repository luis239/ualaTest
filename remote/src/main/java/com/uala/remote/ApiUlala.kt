package com.uala.remote

import com.uala.remote.recipe.model.MealResponseRemote
import com.uala.remote.recipe.model.SearchResponseRemote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiUlala {

    @GET("search.php")
    suspend fun search(
        @Query("s")meal:String
    ):Response<SearchResponseRemote>
}