package com.alexander.media

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mper: MediaPlayer
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mper = MediaPlayer()
        btn1 = findViewById(R.id.btn1)
        btn1.setOnClickListener(this)

        btn2 = findViewById(R.id.btn2)
        btn2.setOnClickListener(this)

        btn3 = findViewById(R.id.btn3)
        btn3.setOnClickListener(this)

        btn4 = findViewById(R.id.btn4)
        btn4.setOnClickListener(this)

    }
    override fun onClick(v: View) {
        mper.reset()
        when (v){
            btn1 -> {
                mper = MediaPlayer.create(this, R.raw.tcyang)
                mper.start()
            }
            btn2 -> {
                mper = MediaPlayer.create(this, R.raw.fly)
                mper.start()
            }
            btn3 -> {
                var vdv: VideoView = findViewById(R.id.vdv)
                var vidControl = MediaController(this)
                vdv.setMediaController(vidControl)
                vdv.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.love))
                vdv.start()
            }
            btn4 -> {
                var vdv: VideoView = findViewById(R.id.vdv)
                var vidControl = MediaController(this)
                vdv.setMediaController(vidControl)
                vdv.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.handpan))
                vdv.start()
            }
        }
    }
}