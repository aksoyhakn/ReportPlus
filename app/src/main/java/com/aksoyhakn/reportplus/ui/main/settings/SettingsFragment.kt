package com.aksoyhakn.reportplus.ui.main.settings

import android.graphics.PorterDuff
import android.support.annotation.ColorRes
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class SettingsFragment :
    BaseFragment<FragmentSettingsBinding>(R.layout.fragment_settings) {

    private val viewModel by viewModels<SettingsViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
    }

}