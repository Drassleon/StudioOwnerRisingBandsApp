package com.herokuapp.risingbands.studioowner.network

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.ANResponse
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.herokuapp.risingbands.studioowner.models.Booking
import okhttp3.Response
import org.xml.sax.ErrorHandler
import java.util.logging.ConsoleHandler

class RisingBandsApi {

    companion object {
        val baseUrl = "https://risingbandsapi.herokuapp.com/api"
        val bookingsUrl = "$baseUrl/booking/"
        val bandsUrl = "$baseUrl/band/"
        val studioRoomsUrl = "$baseUrl/studioroom/"


        //Functions for Bookings

        //Get All
        fun requestBookings(
                responseHandler: (BookingsResponse?) -> Unit,
                errorHandler: (ANError?) -> Unit
        ) {
            AndroidNetworking.get(RisingBandsApi.bookingsUrl)
                    .setPriority(Priority.LOW)
                    .setTag("StudioOwnerRisingBandsApp")
                    .build()
                    .getAsObject(BookingsResponse::class.java, object : ParsedRequestListener<BookingsResponse>{
                        override fun onResponse(response: BookingsResponse?) {
                            responseHandler(response)
                        }
                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    } )
        }

        //New Booking
        fun postBooking(
                booking: Booking,
                errorHandler: (ANError?) -> Unit
        ) {
            AndroidNetworking.post(RisingBandsApi.bookingsUrl)
                    .addQueryParameter("amountHour",booking.amountHour.toString())
                    .addQueryParameter("band",booking.band.toString())
                    .addQueryParameter("bookDate",booking.bookDate)
                    .addQueryParameter("endHour",booking.endHour.toString())
                    .addQueryParameter("id",booking.id.toString())
                    .addQueryParameter("startHour",booking.starHour.toString())
                    .addQueryParameter("studioRoom",booking.studioRoom.toString())
                    .setPriority(Priority.LOW)
                    .setTag("StudioOwnerRisingBandsApp")
                    .build()
        }

        //Functions for Bands

        fun requestBands(
                responseHandler: (BandsResponse?) -> Unit,
                errorHandler: (ANError?) -> Unit
        ) {
            AndroidNetworking.get(RisingBandsApi.bandsUrl)
                    .setPriority(Priority.LOW)
                    .setTag("StudioOwnerRisingBandsApp")
                    .build()
                    .getAsObject(BandsResponse::class.java, object : ParsedRequestListener<BandsResponse>{
                        override fun onResponse(response: BandsResponse?) {
                            responseHandler(response)
                        }
                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    } )
        }

        //Functions for StudioRooms

        fun requestStudioRooms(
                responseHandler: (StudioRoomsResponse?) -> Unit,
                errorHandler: (ANError?) -> Unit
        ) {
            AndroidNetworking.get(RisingBandsApi.studioRoomsUrl)
                    .setPriority(Priority.LOW)
                    .setTag("StudioOwnerRisingBandsApp")
                    .build()
                    .getAsObject(StudioRoomsResponse::class.java, object : ParsedRequestListener<StudioRoomsResponse>{
                        override fun onResponse(response: StudioRoomsResponse?) {
                            responseHandler(response)
                        }
                        override fun onError(anError: ANError?) {
                            errorHandler(anError)
                        }

                    } )
        }



    }

}