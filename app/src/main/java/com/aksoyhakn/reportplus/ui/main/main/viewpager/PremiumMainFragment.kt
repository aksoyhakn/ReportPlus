package com.aksoyhakn.reportplus.ui.main.main.viewpager


import androidx.fragment.app.viewModels
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.databinding.FragmentPremiumMainBinding
import com.aksoyhakn.reportplus.extensions.resString
import com.aksoyhakn.reportplus.ui.main.main.FreeMenuType
import com.aksoyhakn.reportplus.ui.main.main.MainViewModel
import com.aksoyhakn.reportplus.ui.main.main.MenuItem
import com.aksoyhakn.reportplus.ui.main.main.PremiumMenuType
import com.aksoyhakn.reportplus.ui.main.main.adapter.MainCategoryAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PremiumMainFragment :
    BaseFragment<FragmentPremiumMainBinding>(R.layout.fragment_premium_main),
    MainCategoryAdapter.ListenerMainCategory {

    private val viewModel by viewModels<MainViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {
        dataBinding.viewModel = viewModel
        dataBinding.listener = this

        viewModel.preeItemList = arrayListOf<MenuItem>(
            MenuItem(
                1,
                resString(R.string.menu_whoblocked),
                "5",
                PremiumMenuType.WHO_BLOCKED.ordinal
            ),
            MenuItem(
                1,
                resString(R.string.menu_haveblocked),
                "10",
                PremiumMenuType.HAVE_BLOCKED.ordinal
            ),
            MenuItem(
                1,
                resString(R.string.menu_top_commenters),
                "10",
                PremiumMenuType.TOP_COMMENTERS.ordinal
            ),
            MenuItem(
                1,
                resString(R.string.menu_most_like_users),
                "10",
                PremiumMenuType.MOST_LIKED_USERS.ordinal
            ),
            MenuItem(
                1,
                resString(R.string.menu_ghostusers),
                "10",
                PremiumMenuType.GHOST_USERS.ordinal
            )
        )
    }

    override fun clickMainCategory(item: MenuItem) {}

    companion object {
        fun newInstance(): PremiumMainFragment {
            return PremiumMainFragment()
        }
    }
}