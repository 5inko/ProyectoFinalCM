package co.edu.udea.compumovil.proyectofinal.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.udea.compumovil.proyectofinal.infoCompartida.Partido
import co.edu.udea.compumovil.proyectofinal.navigation.AppNavigation
import co.edu.udea.compumovil.proyectofinal.navigation.AppScreens
import co.edu.udea.compumovil.proyectofinal.ui.theme.ProyectoFinalTheme


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VistaInicial(navController: NavController){
    Scaffold {
        LazyColumn (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            item {
                Column {
                    Button(
                        onClick = {navController.navigate(AppScreens.VistaPrincipal.route)},
                        Modifier
                            .width(300.dp)
                            .height(300.dp)
                            .padding(20.dp),
                        shape = RoundedCornerShape(45.dp),
                        ) {
                       Text(text = "Iniciar Nuevo Partido", style = TextStyle(fontSize = 40.sp), textAlign = TextAlign.Center)
                    }
                    Button(onClick = {navController.navigate(AppScreens.HistorialPartidos.route)},
                        Modifier
                            .width(300.dp)
                            .height(300.dp)
                            .padding(20.dp),
                        shape = RoundedCornerShape(45.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(231, 76, 60))
                    ) {
                        Text(text = "Continuar Partido", style = TextStyle(fontSize = 40.sp), textAlign = TextAlign.Center)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPorDefecto() {
    ProyectoFinalTheme {
        AppNavigation(viewModel = Partido())
    }
}