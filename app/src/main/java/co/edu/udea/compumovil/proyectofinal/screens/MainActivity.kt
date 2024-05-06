package co.edu.udea.compumovil.proyectofinal.screens


import android.os.Bundle
import android.support.v4.os.IResultReceiver2.Default
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import co.edu.udea.compumovil.proyectofinal.infoCompartida.Partido
import co.edu.udea.compumovil.proyectofinal.ui.theme.ProyectoFinalTheme
import co.edu.udea.compumovil.proyectofinal.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoFinalTheme {
                // Use MaterialTheme.colors.background para el color de fondo
                val viewModel: Partido = viewModel()
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AppNavigation(viewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProyectoFinalTheme {
        AppNavigation(viewModel = Partido())
    }
}


