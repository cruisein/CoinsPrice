package com.example.myapplication

import com.example.myapplication.ui.HomeScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme() {
                HomeScreen()
                stringResource(id = R.string.high_price)
            }
        }
    }
}