package com.example.myapplication.domain.usecase

import com.example.myapplication.common.Resource
import com.example.myapplication.data.remote.dto.toTicker
import com.example.myapplication.domain.model.Ticker
import com.example.myapplication.domain.repository.TickerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTickersUseCase @Inject constructor(
    private val repository: TickerRepository
) {
    operator fun invoke(): Flow<Resource<List<Ticker>>> = flow {
        try {
            emit(Resource.Loading())
            val tickers = repository.getTickers().map { it.toTicker() }
            emit(Resource.Success(tickers))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach the server. Check your internet connection"))
        }
    }
}