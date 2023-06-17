package com.d3if3005.yummytime.ui

import android.os.Bundle
import android.view.WindowManager
import com.d3if3005.yummytime.R
import com.d3if3005.yummytime.databinding.ActivityPlayerBinding
import com.d3if3005.yummytime.utils.Constant.VIDEO_ID
import com.d3if3005.yummytime.utils.Constant.YOUTUBE_API_KEY
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer

class PlayerActivity : YouTubeBaseActivity() {

    private var _binding: ActivityPlayerBinding? = null
    private val binding get() = _binding!!

    //Other
    private lateinit var player: YouTubePlayer
    private var videoId = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        _binding = ActivityPlayerBinding.inflate(layoutInflater)
        //Full screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(binding.root)
        //Get id
        videoId = intent.getStringExtra(VIDEO_ID).toString()
        //Player initialize
        val listener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer, p2: Boolean) {
                player = p1
                player.loadVideo(videoId)
                player.play()
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {

            }

        }
        binding.videoPlayer.initialize(YOUTUBE_API_KEY, listener)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        //player.release()
    }


}