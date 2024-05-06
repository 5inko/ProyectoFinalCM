package co.edu.udea.compumovil.proyectofinal.navigation


import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.edu.udea.compumovil.proyectofinal.infoCompartida.Partido
import co.edu.udea.compumovil.proyectofinal.screens.HistorialPartidos
import co.edu.udea.compumovil.proyectofinal.screens.ResumenPartido
import co.edu.udea.compumovil.proyectofinal.screens.VistaInicial
import co.edu.udea.compumovil.proyectofinal.screens.VistaPrincipal

@Composable
fun AppNavigation(viewModel: Partido) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.VistaInicial.route) {
        composable(route = AppScreens.VistaInicial.route){
            VistaInicial(navController)
        }
        composable(route = AppScreens.VistaPrincipal.route) {
            VistaPrincipal(navController, viewModel)
        }
        composable(route = AppScreens.HistorialPartidos.route) {
            HistorialPartidos(navController)
        }
        composable(
            route = AppScreens.ResumenPartido.route,
            arguments = listOf(navArgument("equipoGanador") { type = NavType.StringType })
        ) { navBackStackEntry ->
            val equipoGanador = navBackStackEntry.arguments?.getString("equipoGanador")
            equipoGanador?.let {
                ResumenPartido(navController = navController, viewModel)
            }
        }
    }
}