package com.foodtipper.ui.main

import android.content.Intent

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.foodtipper.R
import com.foodtipper.model.FoodItem
import com.foodtipper.ui.detail.DetailActivity
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
class FoodFragment : Fragment() {
    @Inject
    lateinit var mainPresenter: MainPresenter

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       var list =  listOf(FoodItem("asd","asd","asd"),FoodItem("asd","asd","asd"),FoodItem("asd","asd","asd"),FoodItem("asd","asd","asd"))
        val view = inflater.inflate(R.layout.fragment_food_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyFoodRecyclerViewAdapter(list,  ::onItemClick )
            }
        }
        return view
    }

    fun onItemClick (id: String) {      
        val intent = Intent(activity , DetailActivity::class.java)
        intent.putExtra(KEY_FOOD, id)
        startActivity(intent)
        
    }

    companion object {
        const val KEY_FOOD = "KEY_FOOD"
        

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            FoodFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}