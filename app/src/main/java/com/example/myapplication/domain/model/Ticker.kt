package com.example.myapplication.domain.model

data class Ticker(
    val symbol: String,
    val priceChange: Double,
    val priceChangePercent: Double,
    val lastPrice: Double,
    val lastQty: Double,
    val openPrice: Double,
    val highPrice: Double,
    val lowPrice: Double,
    val volume: Double,
    val openTime: Double,
    val closeTime: Double,
    val count: Int
)
