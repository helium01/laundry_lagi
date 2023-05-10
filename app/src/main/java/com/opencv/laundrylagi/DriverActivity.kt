package com.opencv.laundrylagi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.opencv.laundrylagi.fragment.*

class DriverActivity : AppCompatActivity() {
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver)
    }
}