package guia4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import guia4.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column (modifier = Modifier.fillMaxWidth().padding(innerPadding)){
                        scafSnackBar()
                    }


                }
            }
        }
    }
}






///------------------------------888888888888888888888-------------


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scafSnackBar(){

    val scope = rememberCoroutineScope()
    val snackbarHostState= remember {
        SnackbarHostState()
    }

    Scaffold (
        modifier = Modifier.fillMaxSize(),
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Centered Top App Bar", maxLines = 1, overflow = TextOverflow.Ellipsis)
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = ""
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = ""
                        )
                    }
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    val result = snackbarHostState.showSnackbar(
                        message = "snackbar",
                        actionLabel = "undo",
                        duration = SnackbarDuration.Short
                    )
                    when(result){
                        SnackbarResult.Dismissed->{

                        }

                        SnackbarResult.ActionPerformed->{}
                    }
                }
            }) {

                Icon(imageVector = Icons.Default.Check,
                    contentDescription = ""
                    )
            }
        }
    ){
        paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)){  }

    }

}





//-----------------77777777777777777777777777777777---------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun icons(){
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Centered Top App Bar", maxLines = 1, overflow = TextOverflow.Ellipsis)
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = ""
                        )
                    }
                }
            )
        },


        bottomBar = {
            BottomAppBar(

                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Check, contentDescription = "")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Edit, contentDescription = "")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Face, contentDescription = "")
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.CheckCircle, contentDescription = "")
                    }
                }

            )
        }

        ) {
        paddingValues ->

        Column (modifier = Modifier.padding(paddingValues)){
            Text("hola")
        }



    }

}



//--------------------6666666666666666666666666

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun scaforStandar(){
    var buttonName by remember {
        mutableStateOf(0)
    }

    var presses by remember {
        mutableStateOf(0)
    }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    /*Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(text = "ewdwdw")
                    }*/
                    Text(modifier = Modifier.fillMaxWidth(), text = "ewdwdw", textAlign = TextAlign.Center)

                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "button"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {presses++}) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)){

        }

    }

}

//---------------------------font5555555555555555555555555---------





///-------------------------------------444444444-----------------------------------------


@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun businesUi() {

    var buttonName by remember {
        mutableStateOf("")
    }

    var drawerState by remember { mutableStateOf(false) } // Estado del drawer



    ModalNavigationDrawer(
        drawerState = rememberDrawerState(DrawerValue.Closed), // Inicializar estado del drawer
        drawerContent = {
            // Contenido del menú lateral (drawer)
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Opción 1")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Opción 2")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Opción 3")
            }
        }
    ){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            // Barra superior
            TopAppBar(
                title = { Text("Mi Aplicación") },
            )
        },
        floatingActionButton = {
            // Botón de acción flotante (FAB)
            FloatingActionButton(onClick = { /* Acción del FAB */ }) {
                Text("+")
            }
        },

        ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        )
        {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.businness_title),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize * 1.5
                )

            )
            Text(text = "Boton seleccionado", style = MaterialTheme.typography.titleLarge)
            Text(text = buttonName)

        }


        Box(modifier = Modifier.fillMaxWidth())
        {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val list = listOf(
                    "SERVICIOS",
                    "PORTAFOLIO",
                    "ACERCA DE",
                    "CONTACTO",
                    "REDES SOCIALES"
                )

                repeat(list.size) {
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {

                            buttonName = list[it]
                        }
                    ) {
                        Text(text = list[it])
                    }
                }
            }
        }
    }
}

}