package com.example.proyectofinalpamn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.proyectofinalpamn.ui.theme.ProyectoFinalPAMNTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoFinalPAMNTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Principal("David", "LPA", "123456789","@david","a@gmail.com")
                }
            }
        }
    }
}

@Composable
fun Principal(nombre : String, titulo: String, tlf : String, correo: String, email: String) {
    Column(){
        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(70.dp)){
                val image = painterResource(R.drawable.x)
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = nombre,
                    fontSize = 50.sp,
                )
                Text(
                    text = titulo,
                    fontSize = 20.sp,
                )
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().padding(40.dp)) {
            val image = painterResource(R.drawable.x)
            Column(){
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(200.dp)){
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = tlf,
                        fontSize = 20.sp
                    )
                }
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(200.dp)){
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = correo,
                        fontSize = 20.sp
                    )
                }
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.width(200.dp)){
                    Image(
                        painter = image,
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = email,
                        fontSize = 20.sp
                    )
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProyectoFinalPAMNTheme {
        Principal("David", "LPA", "123456789","@david","a@gmail.com")
    }
}