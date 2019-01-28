package com.siddhantkushwaha.android.thugtools.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.siddhantkushwaha.android.thugtools.thugtools.utility.GlideUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        GlideUtil.preload(this@MainActivity, "")
    }
}
