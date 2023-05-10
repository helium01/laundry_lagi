package com.opencv.laundrylagi

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.opencv.laundrylagi.actifity.BaruActivity
import com.opencv.laundrylagi.actifity.LoginActivity
import com.opencv.laundrylagi.fragment.*
import com.opencv.laundrylagi.helper.SharePref
import com.opencv.laundrylagi.model.PaketService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val FragmentHome : Fragment = HomeFragment()
    private val FragmentAkun : Fragment = AkunFragment()
    private val FragmentPaketLaundry : Fragment = PaketLaundryFragment()
    private val FragmentPemasukan : Fragment = PemasukanFragment()
    private val FragmentPembayaran : Fragment = PembayaranFragment()
    private val FragmentPeta : Fragment = PetaFragment()
    private val FragmentProgress : Fragment = ProgressFragment()
    private val fm : FragmentManager = supportFragmentManager
    private var active : Fragment = FragmentHome
    private lateinit var menu : Menu
    private lateinit var menuitem : MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView

    private var status=false
    private lateinit var s:SharePref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        s =SharePref(this)
        if(s.getStatusLogin()){
            if(s.getString(s.role)=="User"){
                setContentView(R.layout.activity_main)
                Log.e("disini",s.getString(s.role))
                setButtonNav()
            }else if(s.getString(s.role)=="Driver"){
                setContentView(R.layout.activity_driver)
                Log.e("disini",s.getString(s.role))
            }else{
                setContentView(R.layout.activity_admin)
                Log.e("disini",s.getString(s.role))
            }
        }else{
            startActivity(Intent(this,BaruActivity::class.java) )
        }

    }


    fun setButtonNav(){
        fm.beginTransaction().add(R.id.container1,FragmentHome).show(FragmentHome).commit()
        fm.beginTransaction().add(R.id.container1,FragmentAkun).hide(FragmentAkun).commit()
        fm.beginTransaction().add(R.id.container1,FragmentPaketLaundry).hide(FragmentPaketLaundry).commit()
        fm.beginTransaction().add(R.id.container1,FragmentPemasukan).hide(FragmentPemasukan).commit()
        fm.beginTransaction().add(R.id.container1,FragmentPembayaran).hide(FragmentPembayaran).commit()
        fm.beginTransaction().add(R.id.container1,FragmentPeta).hide(FragmentPeta).commit()
        fm.beginTransaction().add(R.id.container1,FragmentProgress).hide(FragmentProgress).commit()

        bottomNavigationView=findViewById(R.id.nav_view)
        menu=bottomNavigationView.menu
        menuitem=menu.getItem(0)
        menuitem.isChecked=true

        bottomNavigationView.setOnNavigationItemSelectedListener { item->
            when(item.itemId){
                R.id.navigation_home->{
                    panggilfragment(0,FragmentHome)
                }
                R.id.navigation_paket->{
                    panggilfragment(1,FragmentPaketLaundry)
                }
                R.id.navigation_progres->{
                    panggilfragment(3,FragmentProgress)
                }
                R.id.navigation_user->{
                    panggilfragment(4,FragmentAkun)
                }
                R.id.navigation_pembayaran->{
                    panggilfragment(2,FragmentPembayaran)
                }

            }

            false
        }
    }


    fun panggilfragment(int: Int,fragment: Fragment){
        menuitem=menu.getItem(int)
        menuitem.isChecked=true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }

    object RetrofitClient {
        private const val BASE_URL = "https://api.example.com/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val userService = retrofit.create(PaketService::class.java)
    }
}