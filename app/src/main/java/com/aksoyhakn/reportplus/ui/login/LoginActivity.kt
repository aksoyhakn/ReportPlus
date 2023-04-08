package com.aksoyhakn.reportplus.ui.login

import android.annotation.SuppressLint
import android.os.Build
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.base.activity.BaseActivity
import com.aksoyhakn.reportplus.base.viewmodel.BaseViewModel
import com.aksoyhakn.reportplus.data.preference.PreferenceHelperImp
import com.aksoyhakn.reportplus.databinding.ActivityLoginBinding
import com.aksoyhakn.reportplus.extensions.getCookieHasSession
import com.aksoyhakn.reportplus.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class LoginActivity :
    BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {


    private var webViewClient: CustomWebViewClient? = null
    private var isInitService: Boolean = false

    @Inject
    lateinit var preferenceHelperImp: PreferenceHelperImp

    private val viewModel by viewModels<LoginViewModel>()

    override fun getBaseViewModel(): BaseViewModel = this.viewModel


    override fun bindScreen() {
        initWebview()
    }


    @SuppressLint("SetJavaScriptEnabled")
    fun initWebview() {
        webViewClient = CustomWebViewClient()

        dataBinding.webView.settings.builtInZoomControls = true
        dataBinding.webView.settings.setSupportZoom(true)
        dataBinding.webView.webViewClient = webViewClient as CustomWebViewClient
        dataBinding.webView.settings.javaScriptCanOpenWindowsAutomatically = true
        dataBinding.webView.settings.allowFileAccess = true
        dataBinding.webView.settings.domStorageEnabled = true
        dataBinding.webView.settings.javaScriptEnabled = true

        dataBinding.webView.loadUrl(Constants.URL)

        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cookieManager.setAcceptThirdPartyCookies(dataBinding.webView, true)
        }
    }

    private inner class CustomWebViewClient : WebViewClient() {

        override fun onPageFinished(view: WebView, url: String) {
            val cookies = CookieManager.getInstance().getCookie(url)
            if (cookies.getCookieHasSession() && !isInitService) {
                preferenceHelperImp.setCookie(cookies)
                setResult(1)
                isInitService = true
            }
        }
    }

    override fun onBackPressed() {
        if (dataBinding.webView.isVisible) {
            if (dataBinding.webView.canGoBack())
                dataBinding.webView.goBack()
            else
                super.onBackPressed()
        } else if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

}