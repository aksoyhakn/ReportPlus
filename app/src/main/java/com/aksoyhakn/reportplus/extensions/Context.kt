package com.aksoyhakn.reportplus.extensions

import android.app.Activity
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.text.SpannableString
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.aksoyhakn.reportplus.BuildConfig
import com.aksoyhakn.reportplus.R
import com.aksoyhakn.reportplus.data.service.model.ErrorMessage
import com.aksoyhakn.reportplus.data.service.model.FriendlyMessage
import com.aksoyhakn.reportplus.data.service.util.ErrorModel
import com.aksoyhakn.reportplus.data.service.util.ExceptionHandle
import com.aksoyhakn.reportplus.databinding.DialogDefaultBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

fun Activity?.setWindowFlag(on: Boolean) {
    this?.let {
        val win = it.window
        val winParams = win.attributes
        if (on) {
            winParams.flags =
                winParams.flags or WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        } else {
            winParams.flags =
                winParams.flags and WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS.inv()
        }
        win.attributes = winParams
    }
}


fun Context.getNavigationbarHeight(): Int {
    val result = 0
    val hasMenuKey = ViewConfiguration.get(this).hasPermanentMenuKey()
    val hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK)

    if (!hasMenuKey && !hasBackKey) { //The device h a navigation bar
        val orientation: Int = resources.configuration.orientation
        val resourceId: Int
        resourceId = if (isTablet()) {
            resources.getIdentifier(
                if (orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_height" else "navigation_bar_height_landscape",
                "dimen",
                "android"
            )
        } else {
            resources.getIdentifier(
                if (orientation == Configuration.ORIENTATION_PORTRAIT) "navigation_bar_height" else "navigation_bar_width",
                "dimen",
                "android"
            )
        }
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId)
        }
    }
    return result
}

fun Context?.loadJSONFromAsset(jsonFileName: String): String? {
    this.notNull {
        val manager = it.assets
        val `is` = manager.open(jsonFileName)

        val size = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()
        return String(buffer, Charsets.UTF_8)
    }

    return null
}

fun Context.appendTextColor(
    findCountText: String,
    textColor: Int
): SpannableString {
    val spannable = SpannableString(findCountText)

    spannable.setTextColor(
        this,
        textColor,
        start = 0,
        end = findCountText.length
    )

    return spannable
}


fun Context.handler(duration: Long, listener: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({
        listener()
    }, duration)
}

fun Context.openBrowser(url: String) {
    startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )
    )
}


fun Context.sendToNotificationPermissions() {
    val intent = Intent()
    when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
            intent.action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, this.packageName)
        }
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
            intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
            intent.putExtra("app_package", this.packageName)
            intent.putExtra("app_uid", this.applicationInfo?.uid)
        }
        else -> {
            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.data = Uri.parse("package:" + this.packageName)
        }
    }
    this.startActivity(intent)
}


fun Context.openMarket() {
    val uri: Uri = Uri.parse("market://details?id=com.aksoyhakn.reportplus")
    val goToMarket = Intent(Intent.ACTION_VIEW, uri)
    goToMarket.addFlags(
        Intent.FLAG_ACTIVITY_NO_HISTORY or
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK
    )
    try {
        startActivity(goToMarket)
    } catch (e: ActivityNotFoundException) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("http://play.google.com/store/apps/details?id=$packageName")
            )
        )
    }
}


fun Context.castVerificationCode(message: String): String {
    return Regex("(\\d{6})").find(message)?.value ?: ""
}


fun Context.showDialog(
    item: Any?,
    listenerOkey: () -> Unit,
    listenerCancel: () -> Unit
) {
    this.notNull {
        val dialog = Dialog(it)
        val binding: DialogDefaultBinding =
            DataBindingUtil.inflate(dialog.layoutInflater, R.layout.dialog_default, null, false)

        dialog.setCancelable(false)
        dialog.setContentView(binding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.setCanceledOnTouchOutside(false)

        when (item) {
            is FriendlyMessage -> {
                binding.errorModel = ErrorModel(
                    resDrawable(R.drawable.ic_error_internet, null),
                    item.title,
                    item.message,
                    item.buttonPositive ?: resString(R.string.error_network_buttontext)
                )
            }
            is Throwable -> {
                binding.errorModel = errorString(ExceptionHandle.handleException(item))
            }

            is ErrorMessage -> {
                binding.errorModel = ErrorModel(
                    resDrawable(R.drawable.ic_error_internet, null),
                    item.title,
                    item.message,
                    resString(R.string.error_network_buttontext)
                )
            }
            else -> {}
        }

        binding.ivClose.setSafeOnClickListener {
            dialog.dismiss()
            listenerCancel()
        }

        dialog.show()
    }
}


fun Context.errorString(error: ExceptionHandle.Companion.ERROR?): ErrorModel {
    return when (error) {
        ExceptionHandle.Companion.ERROR.SOCKET_TIMEOUT -> {
            ErrorModel(
                resDrawable(R.drawable.ic_search, null),
                resString(R.string.error_network_title),
                resString(R.string.error_network_description),
                resString(R.string.error_network_buttontext)
            )
        }

        ExceptionHandle.Companion.ERROR.CONNECT_ERROR -> {
            ErrorModel(
                resDrawable(R.drawable.ic_search, null),
                resString(R.string.error_network_title),
                resString(R.string.error_network_description),
                resString(R.string.error_network_buttontext)
            )
        }
        else ->
            ErrorModel(
                resDrawable(R.drawable.ic_search, null),
                resString(R.string.error_network_title),
                resString(R.string.error_network_description),
                resString(R.string.error_network_buttontext)
            )

    }
}

fun Activity?.initStatusBar(): Int {
    this?.let {
        if (Build.VERSION.SDK_INT in 19..20) {
            it.setWindowFlag(true)
        }
        if (Build.VERSION.SDK_INT >= 19) {
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        //make fully Android Transparent Status bar
        if (Build.VERSION.SDK_INT >= 21) {
            it.setWindowFlag(false)
            window.statusBarColor = ContextCompat.getColor(it, R.color.statusbar)
        }
    }

    return -1
}


fun Context.exoPlayerResource(url: String): MediaSource {
    val dataSourceFactory: DataSource.Factory = DefaultHttpDataSource.Factory()
    return ProgressiveMediaSource.Factory(dataSourceFactory)
        .createMediaSource(MediaItem.fromUri(url))
}

fun Context.isOnline(listener: ((Boolean) -> Unit)) {
    listener(
        try {
            val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            netInfo != null && netInfo.isConnected
        } catch (e: NullPointerException) {
            e.printStackTrace()
            false
        }
    )
}

private var mInterstitialAd: InterstitialAd? = null
fun Context.showAds(listener: (InterstitialAd?) -> Unit) {
    var adRequest = AdRequest.Builder().build()

    InterstitialAd.load(
        this,
        if (BuildConfig.DEBUG) {
            "ca-app-pub-3940256099942544/1033173712"
        } else {
            "ca-app-pub-3964734011860669/2123086215"
        },
        adRequest,
        object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
                listener(mInterstitialAd)
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("TAG", "Ad was loaded.")
                mInterstitialAd = interstitialAd
                listener(mInterstitialAd)
            }
        })


    mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
        override fun onAdClicked() {
            // Called when a click is recorded for an ad.
            Log.d("TAG", "Ad was clicked.")
        }

        override fun onAdDismissedFullScreenContent() {
            // Called when ad is dismissed.
            Log.d("TAG", "Ad dismissed fullscreen content.")
            mInterstitialAd = null
            listener(mInterstitialAd)
        }

        override fun onAdFailedToShowFullScreenContent(p0: AdError) {
            // Called when ad fails to show.
            Log.e("TAG", "Ad failed to show fullscreen content.")
            mInterstitialAd = null
            listener(mInterstitialAd)

        }

        override fun onAdImpression() {
            // Called when an impression is recorded for an ad.
            Log.d("TAG", "Ad recorded an impression.")
        }

        override fun onAdShowedFullScreenContent() {
            // Called when ad is shown.
            Log.d("TAG", "Ad showed fullscreen content.")
        }
    }

}




