package com.sujith.kotlin.bottomnavbarkotlin.BottomNavigationBar

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bottombar.AnimatedBottomBar
import com.example.bottombar.components.BottomBarItem
import com.example.bottombar.model.IndicatorStyle
import com.example.bottombar.model.ItemStyle
import com.sujith.kotlin.bottomnavbarkotlin.BottomNavBarScreen


/*
* https://github.com/canopas/compose-animated-navigationbar?tab=readme-ov-file
* */
@Composable
fun AnimatedNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navigationItems = listOf(
        BottomNavBarScreen.Home,
        BottomNavBarScreen.Search,
        BottomNavBarScreen.Profile
    )
    var selectedItem by remember { mutableIntStateOf(0) }

    AnimatedBottomBar(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 75.dp)
            .padding(horizontal = 20.dp)
            .height(70.dp)
            .clip(RoundedCornerShape(35.dp))
            .background(Color.Blue.copy(alpha = 0.5f))
            .animateContentSize(), // Animate changes,
        selectedItem = selectedItem,
        itemSize = navigationItems.size,
        containerColor = Color.LightGray,
        indicatorStyle = IndicatorStyle.LINE,
        indicatorHeight = 5.dp,
        indicatorShape = RoundedCornerShape(50),
        indicatorColor = Color.DarkGray.copy(alpha = 0.7f)
    ) {
        navigationItems.forEachIndexed { index, navigationItem ->
            BottomBarItem(
                selected = currentRoute == navigationItem.route,
                onClick = {
                    if (currentRoute != navigationItem.route) {
                        selectedItem = index
                        navController.popBackStack()
                        navController.navigate(navigationItem.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                imageVector = navigationItem.icon,
                label = navigationItem.title,
                containerColor = Color.LightGray,
                itemStyle = ItemStyle.STYLE2,
            )
        }
    }
}

@Preview(name = "AnimatedNavigationBar")
@Composable
private fun PreviewAnimatedNavigationBar() {
    AnimatedNavigationBar(navController = rememberNavController(), modifier = Modifier)
}