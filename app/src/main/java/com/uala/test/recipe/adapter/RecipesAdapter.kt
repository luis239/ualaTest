package com.uala.test.recipe.adapter

import android.content.Context
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.uala.domain.recipe.model.MealResponseModel
import com.uala.test.databinding.MealItemBinding


class RecipesAdapter (private val meals: List<MealResponseModel>): RecyclerView.Adapter<RecipesAdapter.ProfileViewHolder>(),Filterable{

    private var mealsListFiltered: ArrayList<MealResponseModel> = meals as ArrayList<MealResponseModel>
    private lateinit var context: Context
    private var callback: OnSelectedCallback? = null


    fun setCallback(callback: OnSelectedCallback) {
        this.callback = callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        context = parent.context
        val binding = MealItemBinding.inflate(LayoutInflater.from(context))
        return ProfileViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mealsListFiltered.size
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bindItem(mealsListFiltered[position])

    }

    inner class ProfileViewHolder(private val itemBinding: MealItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun  bindItem(itemMeal : MealResponseModel) {
            Glide.with(context)
                .load(itemMeal.strMealThumb)
                .apply(RequestOptions.circleCropTransform())
                .into(itemBinding.imgItem)
            itemBinding.txtItemTitle.text = itemMeal.strMeal
            itemBinding.descriptionText.text = itemMeal.strCategory
            itemBinding.cardView.setOnClickListener {
                callback?.onItemSelected(itemMeal)
            }



        }

    }


    interface OnSelectedCallback {
        fun onItemSelected(item: MealResponseModel)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                mealsListFiltered = if (charString.isEmpty()) {
                    meals as ArrayList<MealResponseModel>
                } else {
                    val filteredList: ArrayList<MealResponseModel> = ArrayList()
                    for (row in meals) {
                        if (row.strMeal!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = mealsListFiltered
                return filterResults
            }

            override fun publishResults(
                charSequence: CharSequence,
                filterResults: FilterResults
            ) {
                mealsListFiltered = filterResults.values as ArrayList<MealResponseModel>
                // refresh the list with filtered data
                notifyDataSetChanged()
            }
        }
    }
}







