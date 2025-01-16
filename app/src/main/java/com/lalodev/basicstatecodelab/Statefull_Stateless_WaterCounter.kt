package com.lalodev.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatelessCounter(counter: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)){
        if(counter>0){
            Text("You've had $counter glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = counter < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    StatelessCounter(count, { count++ }, modifier)
}

@Preview(showBackground = true)
@Composable
fun StatelessCounterPreview() {
    StatelessCounter(counter = 0, onIncrement = {})
}

@Preview(showBackground = true)
@Composable
fun StatefulCounterPreview() {
    StatefulCounter(modifier = Modifier)
}

/*
    EJEMPLO DE UN USO:


    1-  Ahora puede reutilizar la funcion sin estado:

    Para contar vasos de agua y de zumo recuerdas el waterCount y el juiceCount,
    pero utilizas la misma función composable StatelessCounter para mostrar dos
    estados independientes diferentes.

    @Composable
    fun StatefulCounter() {
        var waterCount by remember { mutableStateOf(0) }

        var juiceCount by remember { mutableStateOf(0) }

        StatelessCounter(waterCount, { waterCount++ })
        StatelessCounter(juiceCount, { juiceCount++ })
    }

    Cuando el usuario presiona para aumentar juiceCount, se recompone StatefulCounter,
    al igual que StatelessCounter que lee juiceCount.
    Sin embargo, el StatelessCounter que lee waterCount no se recompone.


    2- La funcion Statefull puede proporcionar el mismo estado a varias funciones compose

    @Composable
    fun StatefulCounter() {
        var count by remember { mutableStateOf(0) }

        StatelessCounter(count, { count++ })
        AnotherStatelessMethod(count, { count *= 2 })
    }


 */