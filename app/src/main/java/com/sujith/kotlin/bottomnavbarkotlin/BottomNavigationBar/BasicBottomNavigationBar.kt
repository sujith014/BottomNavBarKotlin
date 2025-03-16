package com.sujith.kotlin.bottomnavbarkotlin.BottomNavigationBar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sujith.kotlin.bottomnavbarkotlin.BottomNavBarScreen

@Composable
fun BottomNavigationBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    val screens = listOf(
        BottomNavBarScreen.Home,
        BottomNavBarScreen.Search,
        BottomNavBarScreen.Profile
    )

    val navBackStackEntry = navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
//    val baseScreen = currentRoute?.substringBefore("/") // Remove route parameters

    NavigationBar(
        contentColor = Color.Transparent,
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .padding(horizontal = 25.dp)
                .clip(RoundedCornerShape(35.dp))
                .background(Color(0xFFB38AFD))
                .animateContentSize() // Animate changes
            ,
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentRoute,
                        navHostController = navHostController
                    )
                }
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavBarScreen,
    currentDestination: String?,
    navHostController: NavHostController,
) {
    NavigationBarItem(
        label = {
            Text(screen.route)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "Navigation Icon")
        },
        selected = currentDestination == screen.route,
        onClick = {
            navHostController.navigate(screen.route) {
                popUpTo(navHostController.graph.startDestinationId)
                launchSingleTop = true
            }
        },
        alwaysShowLabel = false,
//        enabled = currentDestination != screen.route, // disable the item if it's the current destination
    )
}

@Preview(name = "BottomNavigationBar")
@Composable
private fun PreviewBottomNavigationBar() {
    BottomNavigationBar(navHostController = rememberNavController(), modifier = Modifier)
}