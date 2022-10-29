package com.example.trendline.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.trendline.base.viewmodel.BaseViewModel
import com.example.trendline.extensions.*
import com.example.trendline.ui.common.LottieProgressDialog
import com.example.trendline.ui.main.MainActivity.Companion.pageCounter
import com.example.trendline.ui.main.MainActivity.Companion.remoteCounter
import com.example.trendline.utils.AutoClearedFragmentValue
import com.example.trendline.utils.analytics.FirebaseAnalyticsHelper
import hideKeyboard
import javax.inject.Inject

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */

abstract class BaseFragment<T : ViewDataBinding>(var layoutId: Int) : Fragment() {

    protected var dataBinding: T by AutoClearedFragmentValue()

    private var progress: LottieProgressDialog? = null

    @Inject
    lateinit var firebaseAnalyticsHelper: FirebaseAnalyticsHelper

    abstract fun getBaseViewModel(): BaseViewModel

    open fun bindScreen() {
        dataBinding.lifecycleOwner = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = DataBindingUtil.inflate(
            inflater,
            layoutId,
            container,
            false
        )
        dataBinding.lifecycleOwner = this
        pageCounter += 1

        if (pageCounter.mod(remoteCounter) == 0) {
            context?.showAds {
                it?.let {
                    it.show(requireActivity())
                }
            }
        }
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindScreen()

        toogleLoading()
        toogleErrorOrFail()
    }

    private fun toogleLoading() {
        getBaseViewModel().fragmentLoading.observe(viewLifecycleOwner) {
            if (it) {
                showLoading()
            } else {
                requireContext().handler(200) {
                    hideLoading()
                }
            }
        }
    }

    private fun toogleErrorOrFail() {
        getBaseViewModel().fragmentErrorOrFail.observe(viewLifecycleOwner) {
            hideLoading()
            requireContext().showDialog(it, {
                activity?.onBackPressed()
            }, {
                activity?.onBackPressed()
            })
        }
    }

    private fun showLoading() {
        hideLoading()
        this.context.notNull { context ->
            progress.isNull {
                progress = LottieProgressDialog(context)
            }
            progress?.show()
        }
    }

    private fun hideLoading() {
        progress.notNull { it.cancel() }
    }

    fun closeKeyboard() {
        requireContext().hideKeyboard()
    }

}