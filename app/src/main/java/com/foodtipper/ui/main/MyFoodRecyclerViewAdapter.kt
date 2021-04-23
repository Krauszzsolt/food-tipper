package com.foodtipper.ui.main

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.foodtipper.R
import com.foodtipper.model.FoodItem
import android.widget.ImageView


/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyFoodRecyclerViewAdapter(
    private val values: List<FoodItem>,
    private val onItemClick: (String) -> Unit
) : RecyclerView.Adapter<MyFoodRecyclerViewAdapter.ViewHolder>() {
    private var view_kl: View? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_food, parent, false)
        this.view_kl = view.findViewById(R.id.imageView_URL)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.name
        holder.contentView.text = item.url
        holder.itemView.setOnClickListener{
            onItemClick(item.id!!)
        }
        var image: Bitmap? = null
        try {
            val `in` = java.net.URL(item.url).openStream()
            image = BitmapFactory.decodeStream(`in`)
        }
        catch (e: Exception) {
            Log.e("Error Message", e.message.toString())
            e.printStackTrace()
        }
        val img = R.id.imageView_URL

//        view_kl.setImageBitmap(image)
    }

    override fun getItemCount(): Int = values.size



    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}