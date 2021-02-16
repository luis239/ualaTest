package com.uala.test.inject

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.uala.data.RecipeRemote
import com.uala.remote.ApiUlalaImpl
import com.uala.remote.recipe.RecipeRemoteImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val remoteModule = module {


    single { ApiUlalaImpl().getApiUlala() }

    //remote
    factory<RecipeRemote> { RecipeRemoteImpl(get()) }




}

