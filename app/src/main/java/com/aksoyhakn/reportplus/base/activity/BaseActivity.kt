package com.aksoyhakn.reportplus.base.activity

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.extensions.*
import com.aksoyhakn.reportplus.ui.common.LottieProgressDialog
import com.aksoyhakn.reportplus.utils.AutoClearedActivityValue
import com.aksoyhakn.reportplus.utils.analytics.FirebaseAnalyticsHelper
import hideKeyboard
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

abstract class BaseActivity<T : ViewDataBinding>(
    var layoutID: Int
) : AppCompatActivity() {

    protected var dataBinding: T by AutoClearedActivityValue()

    private var activityLoading: LottieProgressDialog? = null

    @Inject
    lateinit var firebaseAnalyticsHelper: FirebaseAnalyticsHelper

    open fun getBaseViewModel(): BaseViewModel? = null

    open fun bindScreen() {
        dataBinding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        dataBinding = DataBindingUtil.setContentView(this, layoutID)
        setToolbar()
        bindScreen()

    }

    private fun setToolbar() {
        this.initStatusBar()
    }

    fun showLoading() {
        hideLoading()
        activityLoading.isNull {
            activityLoading = LottieProgressDialog(this)
        }
        activityLoading?.show()
    }

    fun hideLoading() {
        activityLoading.notNull { it.cancel() }
    }

    fun closeKeyboard() {
        hideKeyboard()
    }

    fun clickBack() {
        hideKeyboard()
        onBackPressed()
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            super.onBackPressed()
        } else {
            hideKeyboard()
            finish()
        }
    }

}