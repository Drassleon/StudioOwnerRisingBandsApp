package com.herokuapp.risingbands.studioowner.models

import android.os.Bundle

data class StudioRoom(
        val id: Long,
        val daysAvailable: String,
        val musicStudio: MusicStudio,
        val name: String,
        val priceHour: Float
){
    companion object {
        fun from(bundle: Bundle): StudioRoom{
            return StudioRoom(
                    bundle.getLong("id"),
                    bundle.getString("daysAvailable")!!,
                    MusicStudio.from(bundle.getBundle("musicStudio")!!),
                    bundle.getString("name")!!,
                    bundle.getFloat("priceHour")
            )
        }
    }

    fun toBundle(): Bundle{
        val bundle = Bundle()
        bundle.putLong("id",id)
        bundle.putString("daysAvailable",daysAvailable)
        bundle.putBundle("musicStudio",musicStudio.toBundle())
        bundle.putString("name",name)
        bundle.putFloat("priceHour",priceHour)
        return bundle
    }

}