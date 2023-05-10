package com.opencv.laundrylagi.actifity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.opencv.laundrylagi.MainActivity
import com.opencv.laundrylagi.R
import com.opencv.laundrylagi.helper.SharePref

class BaruActivity : AppCompatActivity() {

    lateinit var s:SharePref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_baru)


        s= SharePref(this)
        mainbutton()
    }

    fun mainbutton(){
        val myButton = findViewById<Button>(R.id.btn_login)
        myButton.setOnClickListener{
//            s.setStatusLogin(true)
            startActivity(Intent(this,LoginActivity::class.java) )
        }
        val myregister = findViewById<Button>(R.id.btn_register)
        myregister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java) )
        }
    }
}