package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConverter(){

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpand by remember { mutableStateOf(false) }
    var oExpand by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(1.00) }
    var oconversionFactor = remember { mutableStateOf(1.00) }

    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Default, // Replace with your desired font family
        fontSize = 16.sp, // Replace with your desired font size
        color = Color.Red // Replace with your desired text color
    )

    fun convertUnits(){
        //?: Elvis Operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oconversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Unit Converter", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue , onValueChange = {
            inputValue = it
            convertUnits()
        }, label = { Text(text = "Enter value")} )
        Row {
          Box {
                    Button(onClick = { iExpand=true }) {
                        Text(inputUnit)
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                    }
              DropdownMenu(expanded = iExpand, onDismissRequest = { iExpand = false }) {
                  DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = {
                      iExpand = false
                      inputUnit="Centimeters"
                      conversionFactor.value = 0.01
                      convertUnits()
                  })
                  DropdownMenuItem(text = { Text(text = "Meters")}, onClick = {
                      iExpand = false
                      inputUnit="Meters"
                      conversionFactor.value = 1.0
                      convertUnits()
                  })
                  DropdownMenuItem(text = { Text(text = "Feet")}, onClick = {
                      iExpand = false
                      inputUnit="Feet"
                      conversionFactor.value = 0.3048
                      convertUnits()
                  })
                  DropdownMenuItem(text = { Text(text = "Inches")}, onClick = {
                      iExpand = false
                      inputUnit="Inches"
                      conversionFactor.value = 0.0254
                      convertUnits()
                  })
                  // Additional length conversion options
                  DropdownMenuItem(text = { Text(text = "Kilometers") }, onClick = {
                      iExpand = false
                      inputUnit = "Kilometers"
                      conversionFactor.value = 1000.0
                      convertUnits()
                  })
                  DropdownMenuItem(text = { Text(text = "Miles") }, onClick = {
                      iExpand = false
                      inputUnit = "Miles"
                      conversionFactor.value = 1609.344
                      convertUnits()
                  })
              }
          }
            Spacer(modifier = Modifier.width(16.dp))
            Box {
                Button(onClick = { oExpand=true }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpand, onDismissRequest = { oExpand=false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = {
                        oExpand = false
                        outputUnit="Centimeters"
                        oconversionFactor.value = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = {
                        oExpand = false
                        outputUnit="Meters"
                        oconversionFactor.value = 1.00
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = {
                        oExpand = false
                        outputUnit="Feet"
                        oconversionFactor.value = 0.3048
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Inches")}, onClick = {
                        oExpand = false
                        outputUnit="Inches"
                        oconversionFactor.value = 0.0254
                        convertUnits()
                    })
                    // Additional length conversion options
                    DropdownMenuItem(text = { Text(text = "Kilometers") }, onClick = {
                        oExpand = false
                        outputUnit = "Kilometers"
                        oconversionFactor.value = 1000.0
                        convertUnits()
                    })
                    DropdownMenuItem(text = { Text(text = "Miles") }, onClick = {
                        oExpand = false
                        outputUnit = "Miles"
                        oconversionFactor.value = 1609.344
                        convertUnits()
                    })
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        // Result Text
        Text("Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium
        )
    }
}


@Preview
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}