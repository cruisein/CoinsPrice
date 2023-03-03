package com.example.myapplication.ui

import com.example.myapplication.R
import com.example.myapplication.domain.model.Ticker
import com.example.myapplication.presentation.HomeViewModel

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val tickers = viewModel.uiState.value.tickers
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(tickers) { ticker ->
                TickerElement(ticker = ticker)
            }
        }
    }
}

@Composable
fun TickerElement(
    ticker: Ticker,
    modifier: Modifier = Modifier
) {
    Surface(color = Color(250, 250, 250)) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = ticker.symbol,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h5
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                ColumnInfos(
                    R.string.price_change,
                    ticker.priceChange.toString(),
                    true,
                    R.string.open_price,
                    ticker.openPrice.toString(),
                    false
                )
                ColumnInfos(
                    label1 = R.string.price_change_percent,
                    value1 = ticker.priceChangePercent.toString(),
                    true,
                    label2 = R.string.low_price,
                    value2 = ticker.lowPrice.toString(),
                false
                )
                ColumnInfos(
                    label1 = R.string.volume,
                    value1 = ticker.volume.toString(),
                    false,
                    label2 = R.string.high_price,
                    value2 = ticker.highPrice.toString(),
                    false
                )
            }
        }
    }
}

@Composable
fun ColumnInfos(
    @StringRes label1: Int,
    value1: String,
    changeValueColor1: Boolean = false,
    @StringRes label2: Int,
    value2: String,
    changeValueColor2: Boolean = false,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        InfoElement(
            label = stringResource(id = label1),
            value = value1,
            changeValueColor = changeValueColor1
        )
        Spacer(modifier = Modifier.height(8.dp))
        InfoElement(
            label = stringResource(id = label2),
            value = value2,
            changeValueColor = changeValueColor2
        )
    }
}

@Composable
fun InfoElement(
    label: String,
    value: String,
    changeValueColor: Boolean,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = label, color = Color.Gray)
        if (changeValueColor) {
            Text(
                text = value, color = if (value.get(0) == '-') {
                    Color.Red
                } else {
                    Color.Green
                }
            )
        } else {
            Text(text = value, color = Color.Black)
        }
    }
    Spacer(modifier = Modifier.width(8.dp))
}