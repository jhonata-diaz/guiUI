package ejemplos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ejemplos.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Login()
            }
        }
    }
}



@Composable
fun Login() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var displayText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Login",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = displayText,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                displayText = "$email $password"
                email = ""
                password = ""
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Submit",
                fontWeight = FontWeight.Bold
            )
        }
    }
}



//--------------------------------------------------------------------------------------------------------


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(){

    var textFielValue by remember { mutableStateOf("") }
    var display by remember { mutableStateOf("thisis a view") }

    Column (modifier = Modifier.fillMaxSize()){
        TopAppBar(
            title = { Text("MY aPP") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = Color(0xFF2E7D32),
                titleContentColor = Color.White
            )
        )

        Spacer(modifier = Modifier.height(150.dp))

        Text(
            display,
            modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        TextField(
            value=textFielValue,
            onValueChange = {textFielValue=it},
            modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth(),
            label = { Text("enter some text") }
        )

        Button(
            onClick = {
                display = textFielValue // Cambia el texto mostrado al valor del TextField
                textFielValue = ""
            },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
            shape= RoundedCornerShape(8.dp),

        ) {
            Text("THIS IS ANOTHER VIEW",
                color = Color.Black,
                fontWeight = FontWeight.Bold
                )
        }
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically // O Alignment.Top, etc.
        ) {
            Checkbox(
                checked = false,
                onCheckedChange = {}
            )
            Text("this is another view", modifier = Modifier.padding(start = 8.dp))
        }

        Row (
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(
                selected = false,
                onClick = {

                }
            )
            Text("THIs a nother view", modifier = Modifier.padding(start = 8.dp))

        }

       /* Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)){

            Checkbox(
                checked = false,
                onCheckedChange = {}
            )
            Text("this is another view", modifier = Modifier.padding(start = 8.dp).padding(top = 14.dp))
        }*/

    }



}







//---------------------practica puntajes

@Composable
fun CourtCounterApp() {
    // Estado del puntaje
    var score1 by remember { mutableStateOf(0) }
    var score2 by remember { mutableStateOf(0) }

    // Estructura visual de la aplicación
    Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween )
    {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título
            Text(
                text = "Court Counter",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del equipo
            Text(
                text = "Team A",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Puntaje actual
            Text(
                text = "$score1",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botones para sumar puntos
            Button(modifier = Modifier.fillMaxWidth().padding(8.dp).height(60.dp),
                shape= RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                , onClick = { score1 += 3 }) {
                Text(text = "+3 POINTS", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth().padding(8.dp).height(60.dp),
                shape = RoundedCornerShape(8.dp),
                colors=ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                onClick = { score1 += 2 }) {
                Text(text = "+2 POINTS", fontSize = 18.sp)

            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth().padding(8.dp).height(60.dp),
                shape = RoundedCornerShape(8.dp),
                colors=ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                onClick = { score1 += 1 }) {
                Text(text = "FREE THROW", fontSize = 18.sp)
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título
            Text(
                text = "Court Counter",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nombre del equipo
            Text(
                text = "Team A",
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Puntaje actual
            Text(
                text = "$score2",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botones para sumar puntos
            Button(modifier = Modifier.fillMaxWidth().padding(8.dp).height(60.dp),
                shape= RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)
                , onClick = { score1 += 3 }) {
                Text(text = "+3 POINTS", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth().padding(8.dp).height(60.dp),
                shape = RoundedCornerShape(8.dp),
                colors=ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                onClick = { score2 += 2 }) {
                Text(text = "+2 POINTS", fontSize = 18.sp)

            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.fillMaxWidth().padding(8.dp).height(60.dp),
                shape = RoundedCornerShape(8.dp),
                colors=ButtonDefaults.buttonColors(containerColor = Color.Yellow),
                onClick = { score2 += 1 }) {
                Text(text = "FREE THROW", fontSize = 18.sp)
            }
        }
    }


}