package com.uala.test.viewmodel

import androidx.lifecycle.MutableLiveData
import com.uala.domain.Failure
import com.uala.domain.recipe.SearchRecipeUseCase
import com.uala.domain.recipe.model.MealResponseModel
import com.uala.test.BaseViewModel
import com.uala.test.Resource
import kotlinx.coroutines.launch

class RecipeViewModel(private val searchRecipeUseCase: SearchRecipeUseCase):BaseViewModel() {


    val responseSearch = MutableLiveData<Resource<List<MealResponseModel>>>()
    fun searchAction(meal : String){
        responseSearch.postValue(Resource.loading())
        launch {
            val params = SearchRecipeUseCase.Params(meal)
            searchRecipeUseCase.invoke(this,params){
                fun handleFailureSearch(failure: Failure) {
                    failure.exception.printStackTrace()

                }

                fun handleSuccessSearch(meals: List<MealResponseModel>) {
                    responseSearch.postValue(Resource.next(meals))
                }
                it.either( ::handleFailureSearch,::handleSuccessSearch)
            }
        }
    }
}