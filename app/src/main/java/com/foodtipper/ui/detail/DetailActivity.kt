package com.foodtipper.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.foodtipper.R
import com.foodtipper.ui.edit.EditFragment
import com.foodtipper.ui.edit.EditPresenter
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailScreen {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)
        supportFragmentManager.beginTransaction().replace(R.id.fragment, EditFragment.newInstance("1", "2")).commit()
    }

    @Inject
    lateinit var detailPresenter: DetailPresenter

    override fun testInjection(text: String) {
        TODO("Not yet implemented")
    }
}