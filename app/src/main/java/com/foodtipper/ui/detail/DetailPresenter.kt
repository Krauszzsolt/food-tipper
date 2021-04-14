package com.foodtipper.ui.detail

import com.foodtipper.ui.Presenter

class DetailPresenter: Presenter<DetailScreen>() {
    fun showtestInjection(text: String) {
        screen?.testInjection(text)
    }
}