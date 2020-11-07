package com.nero.starx.hackjunction.client.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.content.res.ResourcesCompat
import com.nero.starx.hackjunction.paulig.client.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_PAULIGMO)
        setContentView(R.layout.activity_login)

        val background = ResourcesCompat.getDrawable(resources,
                R.drawable.background, theme)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.setBackgroundDrawable(background)
    }


    fun launchAct(v: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent).also {
            finish()
        }
    }
}