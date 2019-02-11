package com.siddhantkushwaha.android.thugtools.sample

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val builder = AlertDialog.Builder(this)
        builder.apply {
            setPositiveButton(
                "OK"
            ) { dialog, id ->

            }
            setNegativeButton(
                "cancel"
            ) { dialog, id ->

            }
        }

        builder.setCancelable(false)
        val alertDialog = builder.create()
        alertDialog.show()
    }
}
