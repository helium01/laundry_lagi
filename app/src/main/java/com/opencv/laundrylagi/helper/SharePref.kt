package com.opencv.laundrylagi.helper

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharePref(activity : Activity) {
    val mypref="basecamp"
    val sp:SharedPreferences
    val login="login"
    val name="name"
    val email="email"
    val role="role"
    val id=""

    init {
        sp=activity.getSharedPreferences(mypref,Context.MODE_PRIVATE)
    }
    fun setStatusLogin(status:Boolean){
        sp.edit().putBoolean(login,status).apply()
    }
    fun getStatusLogin():Boolean{
        return sp.getBoolean(login,false)
    }
    fun setString(key:String,value:String){
        sp.edit().putString(key,value).apply()
    }
    fun setId(data:Int){
        sp.edit().putInt(id,data).apply()
    }
    fun getId():Int{
        return sp.getInt(id,0)
    }
    fun getString(key:String):String{
        return sp.getString(key,"")!!
    }

}