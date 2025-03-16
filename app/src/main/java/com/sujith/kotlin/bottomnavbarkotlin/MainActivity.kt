package com.sujith.kotlin.bottomnavbarkotlin

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.sujith.kotlin.bottomnavbarkotlin.BottomNavigationBar.AnimatedNavigationBar
import com.sujith.kotlin.bottomnavbarkotlin.BottomNavigationBar.BottomNavigationBar
import com.sujith.kotlin.bottomnavbarkotlin.ui.theme.BottomNavBarKotlinTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navHostController = rememberNavController()
            val openAlertDialog = remember { mutableStateOf(false) }

            BackHandler {
                if (navHostController.previousBackStackEntry != null) {
                    navHostController.popBackStack()
                } else {
                    // Alert Dialog for close
                    openAlertDialog.value = true
                }
            }
            if (openAlertDialog.value) {
                AlertDialog(
                    icon = {
                        Icon(Icons.Filled.Close, contentDescription = "Example Icon")
                    },
                    title = {
                        Text(text = "Alert !")
                    },
                    text = {
                        Text(text = "do u want to close?")
                    },
                    onDismissRequest = {
                        openAlertDialog.value = false
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                finish()
                            }
                        ) {
                            Text("Confirm")
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                openAlertDialog.value = false
                            }
                        ) {
                            Text("Dismiss")
                        }
                    },
                    shape = RoundedCornerShape(20.dp)
                )
            }
            BottomNavBarKotlinTheme {
                Scaffold(
                    contentWindowInsets = WindowInsets.safeContent,
                    modifier = Modifier
                        .fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(navHostController = navHostController)
//                        AnimatedNavigationBar(navController = navHostController)
                    }

                ) { innerPadding ->
                    BottomNavBar(
                        navHostController, Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

