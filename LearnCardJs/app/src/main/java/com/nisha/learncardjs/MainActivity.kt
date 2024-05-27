package com.nisha.learncardjs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nisha.learncardjs.ui.theme.LearnCardJsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnCardJsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayYoutubeVideo()
                }
            }
        }
    }
}

@Composable
fun DisplayYoutubeVideo() {
    val videosList = listOf(
        YoutubeData(R.drawable.a, videoTitle = "Learn Sex", channelName = "Android"),
        YoutubeData(R.drawable.b, videoTitle = "Learn Java", channelName = "Apna College"),
        YoutubeData(R.drawable.c, videoTitle = "Learn Figma", channelName = "UI designer")
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(videosList) { video ->
            YoutubeUI(youtubeData = video)
        }
    }

}