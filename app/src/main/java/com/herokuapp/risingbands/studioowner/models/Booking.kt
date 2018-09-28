package com.herokuapp.risingbands.studioowner.models

import android.os.Bundle

data class Booking(
        val id: Long,
        val studioRoom: StudioRoom,
        val band: Band,
        val bookDate: String,
        val amountHour: Int,
        val starHour: Int,
        val endHour: Int
){
    companion object {
        fun from(bundle: Bundle): Booking{
            return Booking(
                    bundle.getLong("id"),
                    StudioRoom.from(bundle.getBundle("studioRoom")!!),
                    Band.from(bundle.getBundle("band")!!),
                    bundle.getString("bookDate")!!,
                    bundle.getInt("amountHour"),
                    bundle.getInt("starHour"),
                    bundle.getInt("endHour")
            )
        }
    }

    fun toBundle(): Bundle{
        val bundle = Bundle()
        bundle.putLong("id",id)
        bundle.putBundle("studioRoom",studioRoom.toBundle())
        bundle.putString("bookDate",bookDate)
        bundle.putInt("amountHour",amountHour)
        bundle.putInt("starHour",starHour)
        bundle.putInt("endHour",endHour)
        return bundle
    }

}