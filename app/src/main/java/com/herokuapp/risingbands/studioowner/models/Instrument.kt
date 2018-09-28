package com.herokuapp.risingbands.studioowner.models

import android.os.Bundle

data class Instrument(
        val id: Long,
        val name: String
){
    companion object {
        fun from(bundle: Bundle): Instrument{
            return Instrument(
                    bundle.getLong("id"),
                    bundle.getString("name")!!
            )
        }
    }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        bundle.putLong("id",id)
        bundle.putString("name",name)
        return bundle
    }

}