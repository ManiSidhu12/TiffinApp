package com.tiffin.app

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.home_screen.*

class Home : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_screen)

        btn_user.setOnClickListener {
            startActivity(Intent(this@Home,MainActivity::class.java))
        }
        btn_list.setOnClickListener {
            startActivity(Intent(this@Home,LocationListing::class.java))
        }
    }
}