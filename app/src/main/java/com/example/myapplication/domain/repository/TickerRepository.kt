package com.example.myapplication.domain.repository

import com.example.myapplication.data.remote.dto.TickerDto

interface TickerRepository {

    suspend fun getTickers(): List<TickerDto>
}