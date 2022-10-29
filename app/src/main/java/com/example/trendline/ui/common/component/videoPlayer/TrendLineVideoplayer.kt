package com.example.trendline.ui.common.component.videoPlayer

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import com.example.trendline.R
import com.example.trendline.base.fragment.BaseFragment
import com.example.trendline.databinding.ComponentVideoplayerBinding
import com.example.trendline.extensions.isNotNull
import com.example.trendline.extensions.linearGradient
import com.example.trendline.extensions.setSafeOnClickListener
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MergingMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource


/**
 * Created by hakanaksoy on 12.09.2022.
 * NargileyeFısıldayanAdam
 */

class TrendLineVideoplayer : RelativeLayout {

    lateinit var databinding: ComponentVideoplayerBinding

    private var exoPlayer: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = false
    private var currentWindow = 0

    private var listener: ListenerVideoPlayer? = null

    private var sbVideoVolume: SeekBar? = null
    private var ivSound: ImageView? = null
    private var llController: LinearLayout? = null
    private var llVolume: LinearLayout? = null
    private var llReplay: LinearLayout? = null
    private var ivShare: ImageView? = null
    private var isMute = false

    constructor(context: Context?) : super(context) {
        init(context, null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    var videoURL = ""
        set(value) {
            if (value.isNotEmpty()) {
                initializeExoPlayer()
            }
            field = value
        }



    @SuppressLint("NewApi")
    private fun init(context: Context?, attrs: AttributeSet?) {
        databinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(context),
                R.layout.component_videoplayer,
                this,
                true
            )


        ivShare = databinding.playerView.findViewById<ImageView>(R.id.exo_share)
        ivShare?.setOnClickListener {

        }

        llReplay = databinding.playerView.findViewById<LinearLayout>(R.id.ll_replay)
        llReplay?.setSafeOnClickListener {
            llController?.visibility = View.VISIBLE
            llVolume?.visibility = View.VISIBLE
            llReplay?.visibility = View.GONE
            listener?.isVideoEnd(false)
            databinding.playerView.controllerHideOnTouch = true
            exoPlayer?.playWhenReady = true
            exoPlayer?.prepare()
        }

        sbVideoVolume = databinding.playerView.findViewById<SeekBar>(R.id.sb_videoVolume)
        sbVideoVolume?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                exoPlayer?.volume = progress.toFloat() / 100.toFloat()

                if (progress != 0) {
                    ivSound?.setImageResource(R.drawable.ic_video_sound)
                } else {
                    ivSound?.setImageResource(R.drawable.ic_video_nosound)
                }

            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        ivSound = databinding.playerView.findViewById<ImageView>(R.id.iv_sound)
        ivSound?.setOnClickListener {
            if (isMute) {
                isMute = false
                ivSound?.setImageResource(R.drawable.ic_video_sound)
                listener?.isVideoMute(false)
                sbVideoVolume?.progress = 100
            } else {
                isMute = true
                listener?.isVideoMute(true)
                ivSound?.setImageResource(R.drawable.ic_video_nosound)
                sbVideoVolume?.progress = 0
            }
        }

        llController = databinding.playerView.findViewById<LinearLayout>(R.id.ll_controller)
        llController?.linearGradient(
            GradientDrawable.Orientation.TOP_BOTTOM, intArrayOf(
                ContextCompat.getColor(context!!, R.color.videoplayer_gradient_1),
                ContextCompat.getColor(context, R.color.videoplayer_gradient_2)
            )
        )



    }


    fun releasePlayer() {
        exoPlayer?.let {
            playWhenReady = it.playWhenReady
            playbackPosition = it.currentPosition
            currentWindow = it.currentWindowIndex
            it.release()
            exoPlayer = null
        }
    }

    fun initializeExoPlayer() {

        exoPlayer = ExoPlayer.Builder(context).build()
        databinding.playerView.player = exoPlayer

        val videoUrl = "https://www.youtube.com/watch?v=5Lk6Yb31S5g"
        val watchYoutuUrl = @SuppressLint("StaticFieldLeak")

        object : YouTubeExtractor(context) {
            override fun onExtractionComplete(
                ytFiles: SparseArray<YtFile>?,
                videoMeta: VideoMeta?
            ) {
                ytFiles?.let {
                    val itag = 22//137
                    val auidoTag = 140
                    val videoUrl = it[itag].url
                    val audioUrl = it[auidoTag].url

                    val audioSource: MediaSource =
                        ProgressiveMediaSource.Factory(DefaultHttpDataSource.Factory())
                            .createMediaSource(MediaItem.fromUri(audioUrl))

                    val videoSource: MediaSource =
                        ProgressiveMediaSource.Factory(DefaultHttpDataSource.Factory())
                            .createMediaSource(MediaItem.fromUri(videoUrl))

                    exoPlayer?.setMediaSource(
                        MergingMediaSource(true, videoSource, audioSource),
                        true
                    )

                    exoPlayer?.volume=0.3F
                    databinding.playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FIT
                    exoPlayer?.videoScalingMode = C.VIDEO_SCALING_MODE_SCALE_TO_FIT
                    exoPlayer?.addListener(object : Player.Listener {
                        override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
                            when (playbackState) {
                                ExoPlayer.STATE_IDLE -> {
                                }
                                ExoPlayer.STATE_BUFFERING -> {
                                }
                                ExoPlayer.STATE_READY -> {
                                    listener?.isVideoPlay(playWhenReady)
                                }
                                ExoPlayer.STATE_ENDED -> {
                                    listener?.isVideoEnd(true)
                                    llController?.visibility = View.GONE
                                    llVolume?.visibility = View.GONE
                                    llReplay?.visibility = View.VISIBLE
                                    databinding.playerView.controllerHideOnTouch = false
                                }
                                else -> {}
                            }
                        }
                    })
                    exoPlayer?.playWhenReady = playWhenReady
                    exoPlayer?.seekTo(currentWindow, playbackPosition)
                    exoPlayer?.prepare()

                }
            }
        }

        watchYoutuUrl.extract(videoUrl)
    }

    @JvmName("setActivity1")
    fun setFragment(fragment: BaseFragment<*>?) {
        fragment?.lifecycle?.addObserver(ExoplayerObserver())
    }

    fun setListener(videoListener: ListenerVideoPlayer) {
        listener = videoListener
    }

    fun setAudioPlaying(isPlaying: Boolean) {
        exoPlayer?.playWhenReady = isPlaying
    }

    fun setPlayWhenReady(status: Boolean) {
        exoPlayer?.playWhenReady = status
    }

    @JvmName("setActivity1")
    fun setActivity(activity: AppCompatActivity?) {
        activity?.lifecycle?.addObserver(ExoplayerObserver())
    }

    interface ListenerVideoPlayer {
        fun isVideoFullScreen(status: Boolean)
        fun isVideoController(isControl:Boolean)
        fun isVideoEnd(videoEnd:Boolean)
        fun isVideoPlay(videoPlay:Boolean)
        fun isVideoMute(videoMute:Boolean)
        fun isVideoShare()
    }

    inner class ExoplayerObserver : DefaultLifecycleObserver {

        override fun onResume(owner: LifecycleOwner) {
            initializeExoPlayer()
        }

        override fun onStart(owner: LifecycleOwner) {
            initializeExoPlayer()
        }

        override fun onStop(owner: LifecycleOwner) {
            releasePlayer()
        }

        override fun onPause(owner: LifecycleOwner) {
            releasePlayer()
        }
    }


    companion object {

        @JvmStatic
        @BindingAdapter(value = ["bind:setVideoPlayer", "bind:setVideoPlayerListener", "bind:setVideoPlayerActivity"])
        fun setVideoPlayer(
            view: TrendLineVideoplayer,
            videoURL: String?,
            listener: ListenerVideoPlayer,
            fragment: BaseFragment<*>
        ) {
            if (videoURL.isNotNull()) {
                view.videoURL = videoURL ?: ""
                view.initializeExoPlayer()
                view.setListener(listener)
                view.setFragment(fragment)
            }
        }
    }
}
