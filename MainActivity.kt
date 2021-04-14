package com.example.Quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        window.decorView.systemUiVisibility = View.System_UI_FLAG_FULLSCREEN
        btn_start.setOnClickListener{

            val intent = Intent(packageContext this,QuizQuestionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}