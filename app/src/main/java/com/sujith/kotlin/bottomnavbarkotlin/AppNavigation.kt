package com.sujith.kotlin.bottomnavbarkotlin

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sujith.kotlin.bottomnavbarkotlin.Screens.HomeScreen
import com.sujith.kotlin.bottomnavbarkotlin.Screens.ProfileScreen
import com.sujith.kotlin.bottomnavbarkotlin.Screens.SearchScreen
import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer


object Routes {
    const val Home = "home"
    const val Search = "search"
    const val Profile = "profile"
}


/*sealed class Routes(){
    @Serializable
    object Home : Routes()
    @Serializable
    object Search : Routes()
    @Serializable
    object Profile : Routes()
}*/

@Composable
fun BottomNavBar(navHostController: NavHostController, modifier: Modifier){

    NavHost(
        navController = navHostController,
        startDestination = Routes.Home,
        enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(500)) },
        exitTransition = { slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(500)) },
        popEnterTransition = { slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(500)) },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(500)) }
    ) {
        composable(Routes.Home) {
            HomeScreen(modifier = modifier)
        }
        composable(Routes.Search) {
            SearchScreen(modifier = modifier)
        }
        composable(Routes.Profile) {
            ProfileScreen(modifier = modifier)
        }
    }
}