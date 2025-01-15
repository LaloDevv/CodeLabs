package com.lalodev.basicstatecodelab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        /*REMEMBER ALMACENA UN VALOR INCLUSO ENTRE RECOMPOSICIONES ASI EVITAMOS QUE LAS VARIABLES SE RESETEEN */
        val count: MutableState<Int> = remember { mutableIntStateOf(0) }
        Text("You've had ${count.value} glasses.")
        Button(onClick = { count.value++ }, Modifier.padding(top = 8.dp)) {
            Text("Add one")
        }
    }
}

// OPCION USANDO 'BY' QUE NOS PERMITE SIMPLIFICAR LA SINTAXIS

/*
fun WaterCounter(modifier: Modifier = Modifier) {
   Column(modifier = modifier.padding(16.dp)) {
       var count by remember { mutableStateOf(0) }

       Text("You've had $count glasses.")
       Button(onClick = { count++ }, Modifier.padding(top = 8.dp)) {
           Text("Add one")
       }
   }
}

 */



@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    WaterCounter()
}
