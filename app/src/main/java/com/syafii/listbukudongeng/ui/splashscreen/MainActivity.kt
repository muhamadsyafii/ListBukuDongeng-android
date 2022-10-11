package com.syafii.listbukudongeng.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.syafii.listbukudongeng.R
import com.syafii.listbukudongeng.ui.listbuku.ListBukuActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ListBukuActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500L)
    }
}
