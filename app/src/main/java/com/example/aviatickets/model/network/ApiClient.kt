package com.example.aviatickets.model.network

import com.example.aviatickets.model.entity.Flight
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



object ApiClient {

    val baseUrl = "https://my-json-server.typicode.com/estharossa/fake-api-demo/offer_list"

    fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("YOUR_BASE_URL")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }



    /**
     *
     * think about performing network request
     */
    interface ApiClient {
        @GET("https://my-json-server.typicode.com/estharossa/fake-api-demo/offer_list")
        suspend fun getFlight(): Response<List<Flight>>
    }
}