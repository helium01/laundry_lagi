package com.opencv.laundrylagi.app

import android.util.Config
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiConfig {
   fun retrofitClientInstance():Retrofit{
       val gson=GsonBuilder().setLenient().create()
       return  Retrofit.Builder().baseUrl("https://service.laundry.com.pt-ckit.com/api/").addConverterFactory(GsonConverterFactory.create(gson)).build()
   }
}