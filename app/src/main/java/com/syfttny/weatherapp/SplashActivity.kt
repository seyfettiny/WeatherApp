package com.syfttny.weatherapp

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.syfttny.weatherapp.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        val delay = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                    runOnUiThread {
                        transitionMain()
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
        delay.start()
    }

    fun transitionMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(
            intent, ActivityOptions.makeClipRevealAnimation(
                binding.root,
                binding.root.width / 2,
                binding.root.height / 2,
                binding.root.baseline,
                binding.root.baseline
            ).toBundle()
        )
        finish()


    }
}