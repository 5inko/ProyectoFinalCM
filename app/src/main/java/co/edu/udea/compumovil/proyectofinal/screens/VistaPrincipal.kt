package co.edu.udea.compumovil.proyectofinal.screens

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import co.edu.udea.compumovil.proyectofinal.navigation.AppNavigation
import co.edu.udea.compumovil.proyectofinal.navigation.AppScreens
import co.edu.udea.compumovil.proyectofinal.ui.theme.ProyectoFinalTheme

//@Preview(showSystemUi = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun VistaPrincipal(navController: NavController) {
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
    var equipo1 by remember {
        mutableStateOf(TextFieldValue())
    }
    var equipo2 by remember {
        mutableStateOf(TextFieldValue())
    }
    var isEditing1 by remember {
        mutableStateOf(false)
    }
    var isEditing2 by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(puntosA, puntosB) {
        if (puntosA >= 25 && puntosA - puntosB > 1) {
            setsA++
            puntosA = 0
            puntosB = 0
        }
        if (puntosB >= 25 && puntosB - puntosA > 1) {
            setsB++
            puntosA = 0
            puntosB = 0
        }
    }

    Scaffold (
        topBar = {
            AppBar(title = "Juego", onNavigationClick = { navController.popBackStack() })
        }
    ) {
        if (isHorizontal) {
            LazyRow(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                item {
                    Column(
                    )

                    {
                        if (isEditing1) {
                            TextField(
                                value = equipo1,
                                onValueChange = { equipo1 = it },
                                modifier = Modifier.width(380.dp),
                                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                            )
                        } else {
                            Text(
                                text = if (equipo1.text.isEmpty()) "Equipo 1" else equipo1.text,
                                modifier = Modifier
                                    .width(380.dp)
                                    .padding(8.dp)
                                    .clickable { isEditing1 = true },
                                textAlign = TextAlign.Center
                            )
                        }
                        Button(
                            onClick = { puntosA++ },
                            Modifier
                                .width(380.dp)
                                .height(150.dp)
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
                                .height(80.dp)
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
                    Column (horizontalAlignment = Alignment.CenterHorizontally){
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
                        if (isEditing2) {
                            TextField(
                                value = equipo2,
                                onValueChange = { equipo2 = it },
                                modifier = Modifier.width(380.dp),
                                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                            )
                        } else {
                            Text(
                                text = if (equipo2.text.isEmpty()) "Equipo 2" else equipo2.text,
                                modifier = Modifier
                                    .width(380.dp)
                                    .padding(8.dp)
                                    .clickable { isEditing2 = true },
                                textAlign = TextAlign.Center

                            )
                        }
                        Button(
                            onClick = { puntosB++ },
                            Modifier
                                .width(380.dp)
                                .height(150.dp)
                                .padding(10.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(231, 76, 60))
                        ) {
                            Text(text = puntosB.toString(), style = TextStyle(fontSize = 80.sp))
                        }
                        Button(
                            onClick = {},
                            Modifier
                                .height(80.dp)
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
                    ) {
                        if (isEditing1) {
                            TextField(
                                value = equipo1,
                                onValueChange = { equipo1 = it },
                                modifier = Modifier.fillMaxWidth(),
                                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)
                            )
                        } else {
                            Text(
                                text = if (equipo1.text.isEmpty()) "Equipo 1" else equipo1.text,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .clickable { isEditing1 = true },
                                textAlign = TextAlign.Center
                            )
                        }
                        Button(
                            onClick = { puntosA++ },
                            Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .padding(10.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0, 151, 167))
                        ) {
                            Text(text = puntosA.toString(), style = TextStyle(fontSize = 70.sp))
                        }
                        Button(
                            onClick = {},
                            Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                                .padding(5.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0, 151, 167))
                        ) {
                            Text(text = "T", style = TextStyle(fontSize = 40.sp))
                        }
                    }
                }
                item {
                    Column (modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally){
                        Text(text = "$setsA - $setsB", style = TextStyle(fontSize = 40.sp))
                    }
                }
                item {
                    Column(
                    ) {
                        if (isEditing2) {
                            TextField(
                                value = equipo2,
                                onValueChange = { equipo2 = it },
                                modifier = Modifier.fillMaxWidth(),
                                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center)

                            )
                        } else {
                            Text(
                                text = if (equipo2.text.isEmpty()) "Equipo 2" else equipo2.text,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .clickable { isEditing2 = true },
                                textAlign = TextAlign.Center
                            )
                        }
                        Button(
                            onClick = { puntosB++ },
                            Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .padding(10.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(231, 76, 60))
                        ) {
                            Text(text = puntosB.toString(), style = TextStyle(fontSize = 80.sp))
                        }
                        Button(
                            onClick = {},
                            Modifier
                                .height(80.dp)
                                .fillMaxWidth()
                                .padding(8.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(231, 76, 60))
                        ) {
                            Text(text = "T", style = TextStyle(fontSize = 40.sp))
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, onNavigationClick: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go back")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewPrincipal(){
    ProyectoFinalTheme {
        AppNavigation()
    }
}

