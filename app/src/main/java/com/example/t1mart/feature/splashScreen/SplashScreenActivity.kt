package com.example.t1mart.feature.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.t1mart.R
import com.example.t1mart.feature.home.MainActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        setUpLottieAnimation()
        moveToNextActivity()
    }


    private fun setUpLottieAnimation() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        screen_text.startAnimation(animation)
    }
    private fun moveToNextActivity() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }
    }
}