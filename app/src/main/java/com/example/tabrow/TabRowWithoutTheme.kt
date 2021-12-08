package com.example.tabrow

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabRowWithoutTheme() {
    val scope = rememberCoroutineScope()
    val pages = remember { listOf(1, 2, 3, 4) }
    val pagerState = rememberPagerState(
        pageCount = pages.size,
        initialPageOffset = 1f,
        initialOffscreenLimit = 3
    )
    Text(text = "Tab Row Without Theme")
    Spacer(Modifier.height(32.dp))
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Black,
        contentColor = Color.Yellow,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .pagerTabIndicatorOffset(pagerState, tabPositions)
                    .clip(RoundedCornerShape(50)),
                height = 2.dp
            )
        },
        tabs = {
            pages.forEachIndexed { index, title ->
                key(index) {
                    Tab(
                        modifier = Modifier.padding(16.dp),
                        text = { Text("$title") },
                        selectedContentColor = Color.Red,
                        unselectedContentColor = Color.Green,
                        selected = pagerState.currentPage == index,
                        onClick = { scope.launch { pagerState.scrollToPage(index) } },
                    )
                }
            }
        }
    )
}
