package com.herokuapp.risingbands.studioowner

import android.app.Application
import com.androidnetworking.AndroidNetworking

class StudioOwnerRisingBandsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        AndroidNetworking.initialize(getApplicationContext())
    }
}