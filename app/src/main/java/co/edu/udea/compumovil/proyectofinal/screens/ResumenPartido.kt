package co.edu.udea.compumovil.proyectofinal.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.udea.compumovil.proyectofinal.infoCompartida.Partido
import co.edu.udea.compumovil.proyectofinal.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ResumenPartido(navController: NavController, viewModel: Partido) {
    val equipoGanador = remember {
        navController.previousBackStackEntry?.arguments?.getString("equipoGanador")
    } ?: ""

    Scaffold {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = {},
                        Modifier
                            .width(380.dp)
                            .height(200.dp)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "El Equipo Ganador Es: $equipoGanador",
                            textAlign = TextAlign.Center,
                            style = TextStyle(fontSize = 40.sp)
                        )
                    }
                    Button(
                        onClick = { navController.navigate(AppScreens.VistaInicial.route)
                            Log.d("equipoGanadorDelPartido","El equipo que ganó el partido es: $equipoGanador")
                            Log.d("equipoGanadorDelPartidoSegunViewModel","El equipo que ganó el partido es: ${viewModel.equipoGanador.value}")
                        },
                        Modifier
                            .width(200.dp)
                            .height(100.dp)
                            .padding(10.dp),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text(text = "Volver al menú Inicial", textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}

