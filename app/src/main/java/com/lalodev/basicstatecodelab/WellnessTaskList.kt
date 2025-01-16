package com.lalodev.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


// esta funcion genera una lista de 30 WellnessTask, parecido al list comprehension (NO LA GUARDA EN NINGUN LADO
fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

// Paso a paso:

// 1. 'fun getWellnessTasks()': Declara una función llamada 'getWellnessTasks' que no recibe parámetros y devuelve un valor.
//    En este caso, no se especifica el tipo de retorno explícitamente, pero Kotlin lo infiere automáticamente.

// 2. '= List(30)': Crea una lista con 30 elementos utilizando la función 'List'.
//    - 'List' es una función estándar en Kotlin que genera una lista inmutable.
//    - El primer argumento (30) especifica el tamaño de la lista.

// 3. '{ i -> WellnessTask(i, "Task # $i") }': Este es un lambda (función anónima) que define cómo generar cada elemento de la lista.
//    - 'i' es el índice actual (de 0 a 29) que proporciona automáticamente 'List' durante la iteración.
//    - 'WellnessTask(i, "Task # $i")' crea un nuevo objeto de tipo 'WellnessTask' con dos parámetros:
//        * El primer parámetro es el índice actual 'i'.
//        * El segundo parámetro es un string que incluye el índice, como "Task # 0", "Task # 1", etc.

// Resultado:
// La función devuelve una lista de 30 objetos 'WellnessTask', donde cada objeto tiene:
// - Un identificador basado en su índice (0 a 29).
// - Una descripción en formato "Task # X".

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember { getWellnessTasks() }
){


    LazyColumn(
        modifier = modifier,

    )  {
        items(list){ task ->
            WellnessTaskItem(taskName = task.label, modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WellnessTaskListPreview() {
    WellnessTaskList()
}