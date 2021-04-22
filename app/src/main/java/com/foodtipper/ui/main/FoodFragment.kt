package com.foodtipper.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.foodtipper.R
import com.foodtipper.model.FoodItem
import com.foodtipper.ui.detail.DetailActivity
import com.foodtipper.ui.injector
import kotlinx.android.synthetic.main.fragment_food_list.*
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 */
class FoodFragment : Fragment(), MainScreen {
    @Inject
    lateinit var mainPresenter: MainPresenter

    private var columnCount = 1
    private var foodAdapter: MyFoodRecyclerViewAdapter? = null
    private val displayedFoods: MutableList<FoodItem> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onStart() {
        super.onStart()
        injector.inject(this)
        mainPresenter.attachScreen(this)
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.refreshFood()
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_food_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

//        var list = listOf(
//            FoodItem("Teszt", "Teszt", "Teszt"),
//            FoodItem("Teszt", "Teszt", "Teszt"),
//            FoodItem("Teszt", "Teszt", "Teszt"),
//            FoodItem("Teszt", "Teszt", "Teszt")
//        )

        // Set the adapter

        list.layoutManager = LinearLayoutManager(context)
        foodAdapter = MyFoodRecyclerViewAdapter(displayedFoods, ::onItemClick)
        list.adapter = foodAdapter
    }

    fun onItemClick(id: String) {
        val intent = Intent(activity, DetailActivity::class.java)
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

    override fun testInjection(text: String) {
        TODO("Not yet implemented")
    }

    override fun showFood(foods: List<FoodItem>) {
        displayedFoods.clear()
        if (foods != null) {
            displayedFoods.addAll(foods)
        }
        foodAdapter?.notifyDataSetChanged()
    }
}