package com.aksoyhakn.reportplus.ui.main.main.viewpager

import androidx.fragment.app.viewModels
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentFreeMainBinding
import com.aksoyhakn.reportplus.extensions.resString
import com.aksoyhakn.reportplus.ui.main.main.FreeMenuType
import com.aksoyhakn.reportplus.ui.main.main.MainViewModel
import com.aksoyhakn.reportplus.ui.main.main.MenuItem
import com.aksoyhakn.reportplus.ui.main.main.adapter.MainCategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FreeMainFragment : BaseFragment<FragmentFreeMainBinding>(R.layout.fragment_free_main),
    MainCategoryAdapter.ListenerMainCategory {

    private val viewModel by viewModels<MainViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listener = this
        viewModel.freeItemList = arrayListOf<MenuItem>(
            MenuItem(
                0,
                resString(R.string.menu_follwers),
                "5",
                FreeMenuType.FOLLOWERS.ordinal
            ),
            MenuItem(
                0,
                resString(R.string.menu_lost_follwers),
                "10",
                FreeMenuType.LOST_FOLLOWERS.ordinal
            ),
            MenuItem(
                0,
                resString(R.string.menu_my_fans),
                "10",
                FreeMenuType.MY_FANS.ordinal
            ),
            MenuItem(
                0,
                resString(R.string.menu_unfollwers),
                "10",
                FreeMenuType.UN_FOLLOWES.ordinal
            ),
            MenuItem(
                0,
                resString(R.string.menu_dofollwers),
                "10",
                FreeMenuType.DO_FOLLOWERS.ordinal
            )
        )
    }

    companion object {
        fun newInstance(): FreeMainFragment {
            return FreeMainFragment()
        }
    }

    override fun clickMainCategory(item: MenuItem) {

    }
}