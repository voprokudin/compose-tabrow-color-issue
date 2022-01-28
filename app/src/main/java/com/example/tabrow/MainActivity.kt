package com.example.tabrow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("asd")
        setContent {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TabRowWithoutTheme()
                Spacer(Modifier.height(100.dp))
                TabRowWithTheme()
            }
        }
    }
}
