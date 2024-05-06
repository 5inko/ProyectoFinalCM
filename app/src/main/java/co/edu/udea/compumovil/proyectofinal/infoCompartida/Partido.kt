package co.edu.udea.compumovil.proyectofinal.infoCompartida

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class Partido : ViewModel(){
    // Estados a Compartir

    //var nombreEquipo1 = mutableStateOf("")
    //var nombreEquipo2 = mutableStateOf("")
    //var setsEquipo1 = mutableStateOf("")
    //var setsEquipo2 = mutableStateOf("")
    var equipoGanador = mutableStateOf("")
    // Eventos a Activar
    val partidoGanado = MutableStateFlow(false)
}
