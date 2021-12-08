package com.example.tabrow

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Assistant = FontFamily(
    Font(R.font.assistant_regular, weight = FontWeight.W700)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h2 = TextStyle(
        fontFamily = Assistant,
        fontSize = 48.sp,
        fontWeight = FontWeight.W700,
        color = BalticSea
    ),
    button = TextStyle(
        fontFamily = Assistant,
        fontSize = 16.sp,
        fontWeight = FontWeight.W700,
        color = Color.White
    ),
    caption = TextStyle(
        fontFamily = Assistant,
        fontSize = 12.sp,
        fontWeight = FontWeight.W600,
        color = RoofTerracotta
    )
)
