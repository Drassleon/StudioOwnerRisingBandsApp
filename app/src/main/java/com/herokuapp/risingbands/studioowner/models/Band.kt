package com.herokuapp.risingbands.studioowner.models

import android.os.Bundle

data class Band(
        val id: Long,
        val genre: Genre,
        val musicRepository: String,
        val name: String,
        val socialMedia: String
){
    companion object {
        fun from(bundle: Bundle): Band {
            return Band(
                    bundle.getLong("id"),
                    Genre.from(bundle.getBundle("genre")!!),
                    bundle.getString("musicRepository")!!,
                    bundle.getString("name")!!,
                    bundle.getString("socialMedia")!!
            )
        }
    }

    fun toBundle(): Bundle{
        val bundle = Bundle()
        bundle.putLong("id",id)
        bundle.putBundle("genre",genre.toBundle())
        bundle.putString("musicRepository",musicRepository)
        bundle.putString("name",name)
        bundle.putString("socialMedia",socialMedia)
        return bundle
    }

}