package com.foodtipper.ui.main

import com.foodtipper.ui.Presenter

class MainPresenter  : Presenter<MainScreen>() {

    fun showtestInjection(text: String) {
        screen?.testInjection(text)
    }
}