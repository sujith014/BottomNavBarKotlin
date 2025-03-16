package com.sujith.kotlin.bottomnavbarkotlin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home : BottomNavBarScreen(
        route = Routes.Home,
        title = "Home",
        icon = Icons.Filled.Home
    )
    object Search : BottomNavBarScreen(
        route = Routes.Search,
        title = "Search",
        icon = Icons.Filled.Search
    )
    object Profile : BottomNavBarScreen(
        route = Routes.Profile,
        title = "Profile",
        icon = Icons.Filled.Person
    )
}
