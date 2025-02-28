package com.example.bottombarapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottombarapp.ui.theme.BottomBarAppTheme
import com.example.bottombarapp.ui.theme.GreenJC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomBarAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyBottomAppBar()
                }
            }
        }
    }
}

@Composable
fun MyBottomAppBar() {
    val navController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = GreenJC) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navController.navigate(Screens.Home.screen) {
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) {
                            Color.White
                        } else {
                            Color.DarkGray
                        }
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navController.navigate(Screens.Search.screen) {
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) {
                            Color.White
                        } else {
                            Color.DarkGray
                        }
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(onClick = {
                        Toast.makeText(context, "Open Bottom Sheet", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = GreenJC
                        )
                    }
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Notifications
                        navController.navigate(Screens.Notification.screen) {
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notifications",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Notifications) {
                            Color.White
                        } else {
                            Color.DarkGray
                        }
                    )
                }

                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navController.navigate(Screens.Profile.screen) {
                            popUpTo(0)
                        }
                    },

                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) {
                            Color.White
                        } else {
                            Color.DarkGray
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Home.screen) { Home() }
            composable(Screens.Search.screen) { Search() }
            composable(Screens.Notification.screen) { Notification() }
            composable(Screens.Profile.screen) { HProfile() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BottomBarAppTheme {
        MyBottomAppBar()
    }
}