package com.uala.test.inject

import com.uala.domain.recipe.SearchRecipeUseCase
import org.koin.dsl.module

val domainModule = module{
    //use cases
    single { SearchRecipeUseCase(get()) }
}