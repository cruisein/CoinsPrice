package com.example.myapplication.data.remote

import com.example.myapplication.data.remote.dto.TickerDto
import retrofit2.http.GET

interface BinanceApi {

    @GET("/api/v3/ticker/24hr")
    suspend fun getTickers(): List<TickerDto>
}