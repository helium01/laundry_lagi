package com.opencv.laundrylagi.actifity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.opencv.laundrylagi.MainActivity
import com.opencv.laundrylagi.R
import com.opencv.laundrylagi.app.ApiConfig
import com.opencv.laundrylagi.app.model.user.ApiService
import com.opencv.laundrylagi.app.model.user.userRequest
import com.opencv.laundrylagi.app.model.user.userResponse
import com.opencv.laundrylagi.helper.SharePref
import retrofit2.Call
import com.opencv.laundrylagi.actifity.BaruActivity
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private lateinit var s: SharePref
    override fun onCreate(savedInstanceState: Bundle?) {
        s = SharePref(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initAction()
    }
    fun initAction(){
        val login = findViewById<Button>(R.id.btn_login)
        login.setOnClickListener {
            login()
        }

    }
    fun login(){
        val email = findViewById<EditText>(R.id.txt_email)
        val password = findViewById<EditText>(R.id.txt_password)
        val pb = findViewById<ProgressBar>(R.id.progres_bar)
        if(email.text.isEmpty()){
            email.error="kolom email tidak boleh kosong"
            email.requestFocus()
            return
        }
        if(password.text.isEmpty()){
            password.error="kolom password tidak boleh kosong"
            password.requestFocus()
            return
        }
        pb.visibility= View.VISIBLE
        val request = userRequest()
        request.email=email.text.toString().trim()
        request.password=password.text.toString().trim()
        val retro=ApiConfig().retrofitClientInstance().create(ApiService::class.java)
        retro.login(request).enqueue(object : retrofit2.Callback<userResponse> {
            override fun onResponse(call: Call<userResponse>, response: Response<userResponse>) {
                pb.visibility=View.GONE
                if (response.isSuccessful) {
                    val userResponse = response.body()
                    val data = userResponse?.data
//                    val token = userResponse?.access_token
                    s.setStatusLogin(true)
                    s.setString("name",data?.name.toString())
                    s.setString("role",data?.role.toString())
                    s.setString("email",data?.email.toString())
                    data?.id?.let { s.setId(it.toInt()) }
                    Toast.makeText(this@LoginActivity, "Selamat datang " + data?.id, Toast.LENGTH_SHORT).show()
                    val intent=Intent(this@LoginActivity,MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK )
                    startActivity(intent)
                    finish()
                    // Lakukan sesuatu dengan token dan data user
                    Log.e("token",data?.name.toString())
                } else {
                    // Tangani error jika permintaan tidak berhasil
                    Log.e("error","error mas")
                }
            }

            override fun onFailure(call: Call<userResponse>, t: Throwable) {
                pb.visibility=View.GONE
                Log.e("error",t.message.toString())
            }

        })
    }
}