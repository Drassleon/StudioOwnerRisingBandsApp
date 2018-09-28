package com.herokuapp.risingbands.studioowner.models

import android.os.Bundle

data class MusicStudio(
        val id: Long,
        val address: String,
        val musicStudioOwner: MusicStudioOwner,
        val name: String,
        val phoneNumber: String
){
    companion object {
        fun from(bundle: Bundle): MusicStudio{
            return MusicStudio(
                    bundle.getLong("id"),
                    bundle.getString("address")!!,
                    MusicStudioOwner.from(bundle.getBundle("musicStudioOwner")!!),
                    bundle.getString("name")!!,
                    bundle.getString("phoneNumber")!!
            )
        }
    }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        bundle.putLong("id",id)
        bundle.putString("address",address)
        bundle.putBundle("musicStudioOwner",musicStudioOwner.toBundle())
        bundle.putString("name",name)
        bundle.putString("phoneNumber",phoneNumber)
        return bundle
    }

}