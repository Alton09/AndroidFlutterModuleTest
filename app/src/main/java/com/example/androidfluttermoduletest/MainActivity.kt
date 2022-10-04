package com.example.androidfluttermoduletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidfluttermoduletest.ui.theme.AndroidFlutterModuleTestTheme
import io.flutter.embedding.android.FlutterActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidFlutterModuleTestTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        // A surface container using the 'background' color from the theme
        var isNativeScreen by remember { mutableStateOf(true) }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (isNativeScreen) {
                    Text(modifier = Modifier.padding(16.dp), text = "Hello World!")
                    Button(onClick = { isNativeScreen = false }) {
                        Text(text = "Navigate to flutter module")
                    }
                } else {
                    CircularProgressIndicator()
                    LocalContext.current.run {
                        startActivity(
                            FlutterActivity.createDefaultIntent(this)
                        )
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        AndroidFlutterModuleTestTheme {
            MainScreen()
        }
    }
}
