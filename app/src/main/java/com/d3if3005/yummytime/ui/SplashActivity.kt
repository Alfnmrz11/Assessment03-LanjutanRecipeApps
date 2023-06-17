package com.d3if3005.yummytime.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.d3if3005.yummytime.databinding.ActivitySplashBinding
import com.d3if3005.yummytime.ui.loginregis.SignupActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        object : Thread() {
            override fun run() {
                try {
                    sleep(2500)
                    startActivity(Intent(baseContext, SignupActivity::class.java))
                } catch (e: Exception) {
                    Log.i(
                        "SplashScreen",
                        "Failed! ${e.message} --- ${e.printStackTrace()}"
                    )
                }
            }
        }.start()
    }
}