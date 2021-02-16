package com.uala.test.inject

import com.uala.data.recipe.RecipeDataImpl
import com.uala.domain.recipe.repository.RecipeRepository
import org.koin.dsl.module

val dataModule = module {

    factory<RecipeRepository> {
        RecipeDataImpl(get())
    }
}