package co.edu.udea.compumovil.proyectofinal

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
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
fun MeimViu() {
    val configuration = LocalConfiguration.current
    val isHorizontal = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    var puntosA by rememberSaveable {
        mutableIntStateOf(0)
    }
    var puntosB by rememberSaveable {
        mutableIntStateOf(0)
    }
    val setsA by rememberSaveable {
        mutableIntStateOf(0)
    }
    val setsB by rememberSaveable {
        mutableIntStateOf(0)
    }

    if (isHorizontal){
        LazyRow(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Column(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Button(
                        onClick = { puntosA++ },
                        Modifier
                            .size(200.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(text = puntosA.toString())
                    }
                    Button(
                        onClick = {},
                        Modifier
                            .size(100.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(text = "T")
                    }
                }
            }
            item {
                Column {
                    Text(text = "$setsA - $setsB", Modifier.padding(top = 40.dp, end = 12.dp))
                }
            }
            item {
                Column(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Button(
                        onClick = { puntosB++ },
                        Modifier
                            .size(200.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(text = puntosB.toString())
                    }
                    Button(onClick = {},
                        Modifier
                            .size(100.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),) {
                        Text(text = "T")
                    }
                }
            }
        }
    } else{
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Row(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Button(
                        onClick = { puntosA++ },
                        Modifier
                            .size(200.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(text = puntosA.toString())
                    }
                    Button(
                        onClick = {},
                        Modifier
                            .size(100.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(text = "T")
                    }
                }
            }
            item {
                Column {
                    Text(text = "$setsA - $setsB", Modifier.padding(top = 40.dp, end = 12.dp))
                }
            }
            item {
                Row(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Button(
                        onClick = { puntosB++ },
                        Modifier
                            .size(200.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                    ) {
                        Text(text = puntosB.toString())
                    }
                    Button(onClick = {},
                        Modifier
                            .size(100.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),) {
                        Text(text = "T")
                    }
                }
            }
        }
    }

}
