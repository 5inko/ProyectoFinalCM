package co.edu.udea.compumovil.proyectofinal.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.edu.udea.compumovil.proyectofinal.navigation.AppNavigation
import co.edu.udea.compumovil.proyectofinal.navigation.AppScreens
import co.edu.udea.compumovil.proyectofinal.ui.theme.ProyectoFinalTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HistorialPartidos (navController: NavController) {
    Scaffold {
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column {
                    Button(onClick = {   // agregar navegacion a historial de partidos
                    },
                        Modifier
                            .width(200.dp)
                            .height(100.dp)
                            .padding(10.dp)
                        ) {
                        Text(text = "Partidos")
                    }
                }
            }
            item {
                Column {
                    Button(onClick = {navController.navigate(AppScreens.VistaInicial.route)},
                        Modifier
                            .width(200.dp)
                            .height(100.dp)
                            .padding(10.dp)
                        ) {
                        Text(text = "Volver al menú Inicial", textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHistorial(){
    ProyectoFinalTheme {
        AppNavigation()
    }
}