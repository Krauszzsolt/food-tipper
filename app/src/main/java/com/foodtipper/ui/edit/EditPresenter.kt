package com.foodtipper.ui.edit

import com.foodtipper.ui.Presenter

class EditPresenter : Presenter<EditScreen>() {
    fun showtestInjection(text: String) {
        screen?.testInjection(text)
    }

}