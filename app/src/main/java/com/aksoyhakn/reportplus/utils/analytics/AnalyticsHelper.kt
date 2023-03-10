package com.aksoyhakn.reportplus.utils.analytics


/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


interface AnalyticsHelper {

    /*  fun setScreen(
          screenName: String,
          activity: BaseActivity<*>?
      )

      fun setScreenFragment(
          screenName: String,
          fragment: BaseFragment<*>?
      )*/

    fun event(
        event: AnalyticsActions.EVENT
    )

    fun event(
        id: String, name: String
    )

    fun eventSelectItem(
        event: AnalyticsActions.EVENT
    )

    fun eventSelectItem(
        id: String, name: String
    )

    fun eventContent(
        event: AnalyticsActions.EVENT
    )

    fun eventContent(
        id: String, name: String
    )

    fun eventSearch(
        name: String
    )
}

object AnalyticsActions {
    enum class EVENT {

        MAIN_HOME {
            override fun eventId() = "click_tab_item_home"
            override fun eventName() = "Ana Ekran"
        };

        abstract fun eventId(): String
        abstract fun eventName(): String
    }
}

object SCREEN {
    const val Splash = "Splash"
}