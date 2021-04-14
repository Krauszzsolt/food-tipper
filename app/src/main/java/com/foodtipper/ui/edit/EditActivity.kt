package com.foodtipper.ui.edit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.foodtipper.R
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