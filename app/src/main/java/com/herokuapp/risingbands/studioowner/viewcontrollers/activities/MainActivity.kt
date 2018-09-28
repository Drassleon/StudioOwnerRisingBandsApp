package com.herokuapp.risingbands.studioowner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.herokuapp.risingbands.studioowner.viewcontrollers.activities.NavigationActivity
import com.herokuapp.risingbands.studioowner.viewcontrollers.fragments.BookingFragment
import com.herokuapp.risingbands.studioowner.viewcontrollers.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton.setOnClickListener{
           startActivity(Intent(this,NavigationActivity::class.java))
        }
    }



}
