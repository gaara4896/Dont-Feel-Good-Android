package com.dontfeelgood.idontfeelsogood

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var interstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, "ca-app-pub-7921227984437156~1891633616")

        adView.loadAd(AdRequest.Builder().build())

        interstitialAd = InterstitialAd(this)
        interstitialAd.adUnitId = "ca-app-pub-3940256099942544/1033173712"
        interstitialAd.loadAd(AdRequest.Builder().build())

        interstitialAd.adListener = object: AdListener() {
            override fun onAdClosed() {
                super.onAdClosed()
                interstitialAd.loadAd(AdRequest.Builder().build())
            }
        }


        val player = MediaPlayer.create(this, R.raw.idontfeelsogood)
        player.isLooping = true

        buttonPlay.setOnClickListener {
            if (player.isPlaying) {
                player.pause()
                buttonPlay.setImageResource(R.drawable.play_button)
                if(interstitialAd.isLoaded) {
                    interstitialAd.show()
                }
            } else {
                player.start()
                buttonPlay.setImageResource(R.drawable.pause_button)
            }
        }
    }
}
