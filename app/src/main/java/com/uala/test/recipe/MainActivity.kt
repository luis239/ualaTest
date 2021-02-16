package com.uala.test.recipe

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.uala.domain.recipe.model.MealResponseModel
import com.uala.test.R
import com.uala.test.Resource
import com.uala.test.databinding.ActivityMainBinding
import com.uala.test.extension.hideLoadingDialog
import com.uala.test.extension.showLoadingDialog
import com.uala.test.recipe.adapter.RecipesAdapter
import com.uala.test.viewmodel.RecipeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), RecipesAdapter.OnSelectedCallback {


    private lateinit var recipesAdapter: RecipesAdapter
    private val recipeViewModel: RecipeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        recipeViewModel.searchAction("chicken")


        recipeViewModel.responseSearch.observe(this, {
            when (it.status) {
                Resource.ResourceState.LOADING -> {
                    showLoadingDialog()
                }
                Resource.ResourceState.NEXT -> {
                   val  meals = it.data
                    recipesAdapter = RecipesAdapter(meals!!)
                    recipesAdapter.setCallback(this)
                    binding.recycler.apply {
                        adapter = recipesAdapter
                        layoutManager = LinearLayoutManager(context)
                        setHasFixedSize(true)
                    }
                    hideLoadingDialog()


                }
                Resource.ResourceState.ERROR -> {
                    Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
                }
                Resource.ResourceState.COMPLETED -> {
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val searchManager =
            getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.action_search)
            .actionView as SearchView
        searchView.setSearchableInfo(
            searchManager
                .getSearchableInfo(componentName)
        )
        searchView.maxWidth = Int.MAX_VALUE
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                recipesAdapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                recipesAdapter.filter.filter(query)
                return false
            }
        })
        return true
    }

    override fun onItemSelected(item: MealResponseModel) {

        val intent = Intent(this, MealDetailsActivity::class.java)
            intent.putExtra(MealDetailsActivity.EXTRA_MEAL,item)
            startActivity(intent)


    }
}