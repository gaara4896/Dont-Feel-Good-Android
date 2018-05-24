package com.dontfeelgood.idontfeelsogood

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player = MediaPlayer.create(this, R.raw.idontfeelsogood)
        player.isLooping = true

        buttonPlay.setOnClickListener {
            if(player.isPlaying){
                player.pause()
                buttonPlay.setImageResource(R.drawable.play_button)
            } else {
                player.start()
                buttonPlay.setImageResource(R.drawable.pause_button)
            }
        }
    }
}
