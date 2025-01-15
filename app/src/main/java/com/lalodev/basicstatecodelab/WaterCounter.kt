package com.lalodev.basicstatecodelab

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        var count by remember { mutableIntStateOf(0) }

        // el texto aparece cuando el contador es mayor que cero
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        // cuando el contador llega a 10 el boton se desabilita
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

// OPCION sin usar 'BY'

/*
fun WaterCounter(modifier: Modifier = Modifier) {
   Column(modifier = modifier.padding(16.dp)) {

       var count: MutableState<Int> = remember { mutableIntStateOf(0) }

        Text("You've had ${count.value} glasses.")
        Button(onClick = { count.value++ }, Modifier.padding(top = 8.dp)) {
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
