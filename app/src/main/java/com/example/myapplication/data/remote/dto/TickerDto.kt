package com.example.myapplication.data.remote.dto

import com.example.myapplication.domain.model.Ticker

data class TickerDto(
    val symbol: String,
    val priceChange: Double,
    val priceChangePercent: Double,
    val weightedAvgPrice: Double,
    val prevClosePrice: Double,
    val lastPrice: Double,
    val lastQty: Double,
    val bidPrice: Double,
    val bidQty: Double,
    val askPrice: Double,
    val askQty: Double,
    val openPrice: Double,
    val highPrice: Double,
    val lowPrice: Double,
    val volume: Double,
    val quoteVolume: Double,
    val openTime: Double,
    val closeTime: Double,
    val firstId: Double,
    val lastId: Double,
    val count: Int
)

fun TickerDto.toTicker(): Ticker {
    return Ticker(
        symbol = symbol,
        priceChange = priceChange,
        priceChangePercent = priceChangePercent,
        lastPrice = lastPrice,
        lastQty = lastQty,
        openPrice = openPrice,
        highPrice = highPrice,
        lowPrice = lowPrice,
        volume = volume,
        openTime = openTime,
        closeTime = closeTime,
        count = count
    )
}