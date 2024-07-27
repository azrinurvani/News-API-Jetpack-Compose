package com.azrinurvani.newsapijetpackcompose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.azrinurvani.newsapijetpackcompose.nav.Action
import com.azrinurvani.newsapijetpackcompose.nav.Destinations
import com.azrinurvani.newsapijetpackcompose.nav.Screen
import com.azrinurvani.newsapijetpackcompose.ui.home.HomeViewModel
import com.azrinurvani.newsapijetpackcompose.ui.theme.NewsApiJetpackComposeTheme
import com.azrinurvani.newsapijetpackcompose.ui.view.home.HomeScreen

@Composable
fun NavCompose(){

    val menuItems = listOf(
        Screen.Home,
        Screen.Saved
    )

    val navController = rememberNavController() // too call navController
    val actions = remember(navController){ //berfungsi untuk action destinations page
        Action(navController)
    }

    NewsApiJetpackComposeTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentDestination = navBackStackEntry?.destination

                    menuItems.forEach { screen ->
                        NavigationBarItem(
                            icon = {
                                Icon(
                                    painter = painterResource(id = screen.drawableId),
                                    contentDescription = stringResource(id = screen.resourceId)
                                )
                            },
                            label = {
                                Text(text = stringResource(id = screen.resourceId))
                            },
                            selected = currentDestination?.hierarchy?.any{
                                if (it.route?.contains("home") == true) { //belum disesuaikan, nanti di fix
                                    screen.route == "home"
                                }else{
                                    it.route == screen.route
                                }
                            } == true,
                            onClick = {
                                navController.navigate(screen.route){
                                    popUpTo(navController.graph.findStartDestination().id){
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        ) { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            
            NavHost(navController = navController, startDestination = Destinations.HOME){
                composable(Destinations.HOME){
                    HomeScreen(
                        modifier = modifier,
                        query = "bitcoin",
                        homeViewModel = hiltViewModel<HomeViewModel>()
                    )
                }
            }

        }
    }
}