package com.nisha.learncheckboxes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nisha.learncheckboxes.ui.theme.LearnCheckboxesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnCheckboxesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LearnCheckBoxes()
                }
            }
        }
    }
}

@Composable
fun LearnCheckBoxes() {
    val todolist: List<String> = listOf("Buy groceries", "sex ", "buy a condom")
    val context = LocalContext.current.applicationContext

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .paint(painterResource(id = R.drawable.nisha), contentScale = ContentScale.FillWidth)
    ) {
        Column(modifier = Modifier.padding(start = 40.dp, top = 180.dp)) {
            todolist.forEach { todoitem ->
                var checkedItem by remember {
                    mutableStateOf(false)
                }
                Row {
                    Checkbox(checked = checkedItem, onCheckedChange = { checkedStatus ->
                        checkedItem = checkedStatus
                        Toast.makeText(context, "$todoitem is $checkedItem", Toast.LENGTH_LONG)
                            .show()
                    })
                    Text(text = todoitem, fontSize = 22.sp)
                }
            }
        }
    }
}

