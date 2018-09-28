package com.herokuapp.risingbands.studioowner.models

import android.os.Bundle
import java.util.*

data class MusicStudioOwner(
        val id: Long,
        val birthDate: String,
        val dni: String,
        val email: String,
        val firstName: String,
        val lastName: String,
        val phoneNumber: String
){
    companion object {
        fun from(bundle: Bundle): MusicStudioOwner{
            return MusicStudioOwner(
                    bundle.getLong("id"),
                    bundle.getString("birthDate")!!,
                    bundle.getString("dni")!!,
                    bundle.getString("email")!!,
                    bundle.getString("firstName")!!,
                    bundle.getString("lastName")!!,
                    bundle.getString("phoneNumber")!!
            )
        }
    }

    fun toBundle(): Bundle {
        val bundle = Bundle()
        bundle.putLong("id",id)
        bundle.putString("birthDate",birthDate)
        bundle.putString("dni",dni)
        bundle.putString("email",email)
        bundle.putString("firstName",firstName)
        bundle.putString("lastName",lastName)
        bundle.putString("phoneNumber",phoneNumber)
        return bundle
    }

}