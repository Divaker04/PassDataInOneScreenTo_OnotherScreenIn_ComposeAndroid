package com.example.composepracticeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.rememberNavController
import com.example.composepracticeapplication.screens.First
import com.example.composepracticeapplication.screens.Second
import com.example.composepracticeapplication.ui.theme.ComposePracticeApplicationTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                   // First(modifier = Modifier.padding(innerPadding))
                    AppNavHost(this@MainActivity)
                }
            }
        }
    }
}
@Composable
fun AppNavHost(mainActivity: MainActivity) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first") {
        composable("first") { First(navController,mainActivity) }
        composable("second/{userName}/{userPassword}",  arguments = listOf(
            navArgument("userName") { type = NavType.StringType },
            navArgument("userPassword") { type = NavType.StringType }
        )) {backStackEntry->
            val userName=backStackEntry.arguments?.getString("userName")
            val userPassword=backStackEntry.arguments?.getString("userPassword")
            Second(navController,userName,userPassword) }
    }
}