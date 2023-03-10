package com.aksoyhakn.reportplus.ui.main.splash

import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.fragment.BaseFragment
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.service.model.FriendlyMessage
import com.aksoyhakn.reportplus.databinding.FragmentSplashBinding
import com.aksoyhakn.reportplus.extensions.*
import com.aksoyhakn.reportplus.ui.main.MainActivity.Companion.remoteCounter
import com.aksoyhakn.reportplus.ui.main.splash.model.RemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.net.UnknownHostException


/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayaAdam
 */


@AndroidEntryPoint
class SplashFragment :
    BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    private val viewModel by viewModels<SplashViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel

    override fun bindScreen() {

        val animZoomIn: Animation = AnimationUtils.loadAnimation(context, R.anim.splash_anim)
        animZoomIn.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                context?.isOnline {
                    if (it) {
                        initRemoteConfig()
                    } else {
                        requireContext().showDialog(UnknownHostException(), {}, {})
                    }
                }
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
        dataBinding.ivSplash.startAnimation(animZoomIn)

    }

    override fun onResume() {
        super.onResume()
        //initRemoteConfig()
    }

    private fun initRemoteConfig() {

     /*   val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(360L)
            .build()

        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.fetchAndActivate()
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    var remoteJson: String? = remoteConfig.getString("and_remote_config")
                    remoteJson?.takeIf { it.isNotBlank() }?.apply {
                        navigateToDashboard(
                            Gson().fromJson(
                                this,
                                RemoteConfig::class.java
                            )
                        )
                    }
                } else {
                    requireContext().showDialog(UnknownHostException(), {}, {})
                }
            }
            .addOnFailureListener { exception ->
                requireContext().showDialog(UnknownHostException(), {}, {})
            }
            .addOnCanceledListener {
                requireContext().showDialog(UnknownHostException(), {}, {})
            }

      */

        navigateToDashboard()
    }

    private fun navigateToDashboard(data: RemoteConfig?=null) {

        context?.handler(500) {
            Navigation.findNavController(dataBinding.root)
                .navigate(R.id.action_splashFragment_to_homeFragment)
        }

       /* remoteCounter = data.pageCounter ?: 4
        if (data.isForceUpdate != true ) {

            context?.handler(500) {
                Navigation.findNavController(dataBinding.root)
                    .navigate(R.id.action_splashFragment_to_homeFragment)
            }

        } else {

            context?.handler(500) {
                requireContext().showDialog(
                    FriendlyMessage(
                        resString(R.string.new_version),
                        resString(R.string.new_version_description),
                        false,
                        resString(R.string.new_version_cancel),
                        resString(R.string.new_version_ok),
                        ""
                    ),
                    {
                        requireContext().openMarket()
                    },
                    {
                        requireActivity().finish()
                    }
                )
            }

        }
        */
    }

}