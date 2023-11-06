package com.example.technicaltestandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.technicaltestandroid.models.AuthenticationResult
import com.example.technicaltestandroid.screen.LoginScreen
import com.example.technicaltestandroid.screen.SurveyListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val authenticationResult = remember { mutableStateOf(AuthenticationResult.NONE) }

            when (authenticationResult.value) {
                AuthenticationResult.NONE -> {
                    LoginScreen(onLoginClicked = { username, password ->
                        authenticationResult.value = AuthenticationResult.SUCCESS
                    })
                }
                AuthenticationResult.SUCCESS -> {
                    SurveyListScreen()
                }
                AuthenticationResult.FAILURE -> {
                    FailureScreen(errorMessage = "User or Password incorrect")
                }
            }
        }
    }
}
@Composable
fun FailureScreen(errorMessage: String) {
    Text(
        text = errorMessage,
        color = Color.Red,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    )
}
