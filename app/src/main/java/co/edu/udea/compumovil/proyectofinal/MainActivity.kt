package co.edu.udea.compumovil.proyectofinal

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    var setsA by rememberSaveable {
        mutableIntStateOf(0)
    }
    var setsB by rememberSaveable {
        mutableIntStateOf(0)
    }

    LaunchedEffect(puntosA, puntosB) {
        if (puntosA >= 25 && puntosA - puntosB > 1) {
            setsA++
            puntosA = 0
            puntosB = 0
        }
        if (puntosB >= 25 && puntosB - puntosA > 1) {
            setsA++
            puntosA = 0
            puntosB = 0
        }
    }

    if (isHorizontal) {
        LazyRow(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            item {
                Column(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Button(
                        onClick = { puntosA++ },
                        Modifier
                            .width(380.dp)
                            .height(250.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0, 151, 167))
                    ) {
                        Text(
                            text = puntosA.toString(),
                            Modifier.padding(end = 5.dp),
                            style = TextStyle(fontSize = 80.sp)
                        )
                    }
                    Button(
                        onClick = {},
                        Modifier
                            .height(100.dp)
                            .width(380.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0, 151, 167))
                    ) {
                        Text(text = "T", style = TextStyle(fontSize = 50.sp))
                    }
                }
            }
            item {
                Column {
                    Text(
                        text = "$setsA - $setsB",
                        style = TextStyle(fontSize = 40.sp)
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Button(
                        onClick = { puntosB++ },
                        Modifier
                            .width(380.dp)
                            .height(250.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(231, 76, 60))
                    ) {
                        Text(text = puntosB.toString(), style = TextStyle(fontSize = 80.sp))
                    }
                    Button(
                        onClick = {},
                        Modifier
                            .height(100.dp)
                            .width(380.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(231, 76, 60))
                    ) {
                        Text(text = "T", style = TextStyle(fontSize = 50.sp))
                    }
                }
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            item {
                Column(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Button(
                        onClick = { puntosA++ },
                        Modifier
                            .width(380.dp)
                            .height(250.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0, 151, 167))
                    ) {
                        Text(text = puntosA.toString(), style = TextStyle(fontSize = 80.sp))
                    }
                    Button(
                        onClick = {},
                        Modifier
                            .height(100.dp)
                            .width(380.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0, 151, 167))
                    ) {
                        Text(text = "T", style = TextStyle(fontSize = 50.sp))
                    }
                }
            }
            item {
                Column {
                    Text(text = "$setsA - $setsB", style = TextStyle(fontSize = 40.sp))
                }
            }
            item {
                Column(
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Button(
                        onClick = { puntosB++ },
                        Modifier
                            .width(380.dp)
                            .height(250.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(231, 76, 60))
                    ) {
                        Text(text = puntosB.toString(), style = TextStyle(fontSize = 80.sp))
                    }
                    Button(
                        onClick = {},
                        Modifier
                            .height(100.dp)
                            .width(380.dp)
                            .padding(8.dp),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(231, 76, 60))
                    ) {
                        Text(text = "T", style = TextStyle(fontSize = 50.sp))
                    }
                }
            }
        }
    }

}
