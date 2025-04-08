package com.example.tacos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tacos.ui.theme.TacosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TacosTheme {
                // Criar o NavController dentro do composable
                val navController = rememberNavController()  // Aqui é onde o rememberNavController é chamado

                // Configurando a navegação
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") { HomeScreen(navController) }
                    composable("menu") { MenuScreen(navController) }
                    composable("tacoDetails") { TacoDetailsScreen() }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Bem-vindo à Tacos!")
        Button(onClick = { navController.navigate("menu") }) {
            Text("Ver o Menu de Tacos")
        }
    }
}

@Composable
fun MenuScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Menu de Tacos")
        Button(onClick = { navController.navigate("tacoDetails") }) {
            Text("Detalhes do Taco")
        }
        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar para Home")
        }
    }
}

@Composable
fun TacoDetailsScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Detalhes do Taco!")
        Text("Aqui estão os detalhes deliciosos do seu taco favorito.")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TacosTheme {
        HomeScreen(rememberNavController())  // Aqui também é usado rememberNavController corretamente
    }
}
