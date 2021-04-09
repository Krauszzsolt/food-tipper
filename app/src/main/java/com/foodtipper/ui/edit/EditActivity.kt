package com.foodtipper.ui.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.foodtipper.R
import com.foodtipper.ui.main.FoodFragment
import com.foodtipper.ui.main.MainPresenter
import javax.inject.Inject

class EditActivity : AppCompatActivity(), EditScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, EditFragment.newInstance("s","s")).commit()

    }
    @Inject
    lateinit var editPresenter: EditPresenter


    override fun testInjection(text: String) {
        TODO("Not yet implemented")
    }
}