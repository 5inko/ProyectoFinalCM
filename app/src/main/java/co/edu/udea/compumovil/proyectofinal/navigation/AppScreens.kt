package co.edu.udea.compumovil.proyectofinal.navigation

sealed class AppScreens(val route: String) {
    object VistaInicial : AppScreens("inicial")
    object VistaPrincipal : AppScreens("main")
    object HistorialPartidos : AppScreens("historial")
    object ResumenPartido : AppScreens("resumen/{equipoGanador}") {
        fun createRoute(equipoGanador: String) = "resumen/$equipoGanador"
    }
}
