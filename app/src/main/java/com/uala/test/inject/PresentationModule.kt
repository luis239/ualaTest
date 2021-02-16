package com.uala.test.inject


import com.uala.test.viewmodel.RecipeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
   viewModel { RecipeViewModel(get())}
}