package com.example.tradeonline.ui.videoPlayer

import android.content.res.Configuration
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.tradeonline.R
import com.example.tradeonline.base.activity.BaseActivity
import com.example.tradeonline.databinding.ActivityVideoBinding
import com.example.tradeonline.extensions.handler
import com.example.tradeonline.utils.Constants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class VideoPlayerActivity :
    BaseActivity<ActivityVideoBinding>(R.layout.activity_video) {

    private val youtubeURL: String? by lazy {
        intent?.extras?.getString(Constants.Main.YOUTUBE_URL)
    }

    override fun bindScreen() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, dataBinding.playerView).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        dataBinding.playerView.addYouTubePlayerListener(object: AbstractYouTubePlayerListener(){
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youtubeURL?.let {
                    youTubePlayer.loadOrCueVideo(lifecycle, it, 0f)
                    handler(100) {
                        youTubePlayer.loadVideo(it, 0f)
                    }
                }

                youTubePlayer.removeListener(this)
            }

        })
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            dataBinding.playerView.enterFullScreen()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            dataBinding.playerView.exitFullScreen()
        }
    }

}
