package co.edu.udea.compumovil.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import co.edu.udea.compumovil.proyectofinal.ui.theme.ProyectoFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoFinalTheme {
                    MeimViu()
                }
            }
        }
    }


@Preview(showSystemUi = true)
@Composable
fun MeimViu () {
    var puntosA by rememberSaveable {
        mutableIntStateOf(0)
    }
    var puntosB by rememberSaveable {
        mutableIntStateOf(0)
    }
    var setsA by rememberSaveable {
        mutableIntStateOf(0)
    }
    var setsB by rememberSaveable {
        mutableIntStateOf(0)
    }
    LazyRow {
        item {
            LazyColumn (
                Modifier
                    .padding(end = 16.dp))
                    {
                item {
                    Button(onClick = {puntosA++}) {
                        Text(text = puntosA.toString())
                    }
                    Button(onClick = {}) {
                        Text(text = "T")
                    }
                }
            }
            LazyColumn {
                item {
                    LazyRow {
                        item {
                            Text(text = setsA.toString())
                            Text(text = "-")
                            Text(text = setsB.toString())
                        }
                    }
                }
            }
            LazyColumn {
                item {
                    Button(onClick = {puntosB++}) {
                        Text(text = puntosB.toString())
                    }
                    Button(onClick = {}) {
                        Text(text = "T")
                    }
                }
            }
        }
    }
}