package com.example.composepracticeapplication.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Second(navController: NavHostController, userName: String?, userPassword: String?) {


        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = "Hello  $userName")
                Text(text = "Hello $userPassword")
            }

        }


}