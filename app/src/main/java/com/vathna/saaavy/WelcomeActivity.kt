package com.vathna.saaavy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_welcome)

        btnLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        btnHowItWork.setOnClickListener {
            startActivity(Intent(this,WalkThroughActivity::class.java))
        }
    }
}
