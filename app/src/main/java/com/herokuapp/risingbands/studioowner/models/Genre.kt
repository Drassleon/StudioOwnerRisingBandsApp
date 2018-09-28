package com.herokuapp.risingbands.studioowner.models

import android.os.Bundle

data class Genre(
        val id: Long,
        val name: String
){
    companion object {
        fun from(bundle: Bundle): Genre{
            return Genre(
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