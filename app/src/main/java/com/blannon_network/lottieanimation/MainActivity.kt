package com.blannon_network.lottieanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.blannon_network.lottieanimation.ui.theme.LottieAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LottieAnimationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WelcomeScreen()
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation))
    var isPlaying by remember{
        mutableStateOf(true)
    }
    val progress by animateLottieCompositionAsState(composition = composition,
        isPlaying= isPlaying)

    LaunchedEffect(key1 = progress){
        if (progress == 0f)
            isPlaying = true
    }
    if (progress == 1f)
        isPlaying = false
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, 
        horizontalAlignment = Alignment.CenterHorizontally 
    ){
        LottieAnimation(
            modifier = Modifier.size(250.dp),
            composition = composition,
        progress = {progress})
        Button(onClick = {isPlaying = true}) {
            Text(text = "Add to Cart")
            
        }
        
    }

}