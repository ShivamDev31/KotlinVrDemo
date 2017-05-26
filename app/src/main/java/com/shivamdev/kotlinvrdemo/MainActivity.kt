package com.shivamdev.kotlinvrdemo

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.vr.sdk.widgets.video.VrVideoEventListener
import com.google.vr.sdk.widgets.video.VrVideoView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val vrViewView = findViewById(R.id.vr_video_view) as VrVideoView
        val options = VrVideoView.Options()
        options.inputFormat = VrVideoView.Options.FORMAT_DEFAULT
        options.inputType = VrVideoView.Options.TYPE_STEREO_OVER_UNDER
        val videoUri = Uri.parse("http://techslides.com/demos/sample-videos/small.mp4")
        // Set inputFormat as FORMAT_HLS for streaming below video
        //val videoUri = Uri.parse("http://storage.googleapis.com/vrview/examples/video/hls/congo.m3u8")
        vrViewView.setEventListener(VrLoadingListener())
        vrViewView.loadVideo(videoUri, options)
        //vrViewView.loadVideoFromAsset("congo.mp4", options)
    }

    class VrLoadingListener : VrVideoEventListener() {
        override fun onLoadSuccess() {
            super.onLoadSuccess()
            Log.d("VrVideo : ", "Video loaded successfully")
        }

        override fun onLoadError(errorMessage: String?) {
            super.onLoadError(errorMessage)
            Log.e("VrVideoError : ", errorMessage?: "Null")
        }
    }
}
