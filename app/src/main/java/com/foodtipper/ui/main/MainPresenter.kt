package com.foodtipper.ui.main

import com.foodtipper.interactor.Event
import com.foodtipper.interactor.api.ApiInteractor
import com.foodtipper.interactor.api.event.GetFoodsApiEvent
import com.foodtipper.ui.Presenter
import org.greenrobot.eventbus.EventBus

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter  @Inject constructor(private val executor: Executor, private val foodInteractor: ApiInteractor ) : Presenter<MainScreen>() {
    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun showtestInjection(text: String) {
        screen?.testInjection(text)
    }

    fun refreshFood() {
        executor.execute {
            foodInteractor.getFoods()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetFoodsApiEvent) {
        if (event.exception != null) {
            event.exception?.printStackTrace()

        } else {
            if (screen != null) {
                if (event.foods != null) {
                    screen?.showFood(event.foods!!)
                }

            }
        }
    }

}