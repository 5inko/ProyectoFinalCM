package co.edu.udea.compumovil.proyectofinal.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import co.edu.udea.compumovil.proyectofinal.screens.HistorialPartidos
import co.edu.udea.compumovil.proyectofinal.screens.VistaInicial
import co.edu.udea.compumovil.proyectofinal.screens.VistaPrincipal

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.VistaInicial.route) {
        composable(route = AppScreens.VistaInicial.route){
            VistaInicial(navController)
        }
        composable(route = AppScreens.VistaPrincipal.route) {
            VistaPrincipal(navController)
        }
        composable(route = AppScreens.HistorialPartidos.route) {
            HistorialPartidos(navController)
        }
    }
}