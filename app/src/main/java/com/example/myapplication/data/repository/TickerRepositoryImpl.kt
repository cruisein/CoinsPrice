package com.example.myapplication.data.repository

import com.example.myapplication.data.remote.BinanceApi
import com.example.myapplication.data.remote.dto.TickerDto
import com.example.myapplication.domain.repository.TickerRepository
import javax.inject.Inject

class TickerRepositoryImpl @Inject constructor(
    private val api: BinanceApi
) : TickerRepository {
    override suspend fun getTickers(): List<TickerDto> {
        return api.getTickers()
    }
}