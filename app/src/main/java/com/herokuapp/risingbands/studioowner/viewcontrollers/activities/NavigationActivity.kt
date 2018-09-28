package com.herokuapp.risingbands.studioowner.viewcontrollers.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.herokuapp.risingbands.studioowner.MainActivity
import com.herokuapp.risingbands.studioowner.R
import com.herokuapp.risingbands.studioowner.viewcontrollers.fragments.BookingFragment
import com.herokuapp.risingbands.studioowner.viewcontrollers.fragments.MusicRoomFragment
import com.herokuapp.risingbands.studioowner.viewcontrollers.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.fragment_profile.*


class NavigationActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener navigateTo(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_profile
    }

    private fun fragmentFor(item: MenuItem): Fragment {

        when(item.itemId){

            R.id.navigation_profile -> {
                return ProfileFragment()
            }
            R.id.navigation_room -> {
                return MusicRoomFragment()
            }
            R.id.navigation_booking -> {
                return BookingFragment()
            }

        }

        return ProfileFragment()
    }

    private fun navigateTo(item: MenuItem): Boolean {
        item.setChecked(true)
        return supportFragmentManager
                .beginTransaction()
                .replace(R.id.content,fragmentFor(item))
                .commit() > 0
    }
}
