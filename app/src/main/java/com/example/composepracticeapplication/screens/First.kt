package com.example.composepracticeapplication.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composepracticeapplication.MainActivity


@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun First(navController: NavHostController, mainActivity: MainActivity) {
    var isError by rememberSaveable { mutableStateOf(false) }
    var userName by remember { mutableStateOf("") }
    var userPassword by remember { mutableStateOf("") }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()

    ) {

        val keyboardController = LocalSoftwareKeyboardController.current

        Column(
            modifier = Modifier
                .padding(16.dp)
                .imePadding(), // This will add padding to avoid the keyboard
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = userName,
                onValueChange = { userName = it },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                supportingText ={
                                if (isError){
                                    Text(text = "Enter UserName")
                                }
                } ,
                trailingIcon = {
                               if (isError){
                                   Icon(Icons.Filled.Info,"Error", tint = MaterialTheme.colorScheme.error)
                               }
                },
                label = { Text(text = "User Name") },
                keyboardOptions  = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            )
            OutlinedTextField(
                value = userPassword,
                onValueChange = { userPassword = it },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 1,
                keyboardOptions  = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                label = { Text(text = "User Password") }
            )
            Button(
                onClick = {
                    // Handle form submission
//                    if (userName!=""){
//                      Toast.makeText(mainActivity,"Enter User Name",Toast.LENGTH_SHORT).show()
//                    }else if(userPassword!=""){
//                        Toast.makeText(mainActivity,"Enter Password",Toast.LENGTH_SHORT).show()
//
//                    }else{
//                        keyboardController?.hide()
//                        navController.navigate("second/$userName/$userPassword")// Optionally hide the keyboard on submit
//                    }

                    if (userName.isEmpty()) {
                        Toast.makeText(mainActivity, "Enter User Name", Toast.LENGTH_SHORT).show()
                    } else if (userPassword.isEmpty()) {
                        Toast.makeText(mainActivity, "Enter Password", Toast.LENGTH_SHORT).show()
                    } else {
                        keyboardController?.hide()
                        navController.navigate("second/$userName/$userPassword")
                    }

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }
    }
}