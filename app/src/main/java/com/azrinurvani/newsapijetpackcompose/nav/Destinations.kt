package com.azrinurvani.newsapijetpackcompose.nav

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavController
import com.azrinurvani.newsapijetpackcompose.R
import com.azrinurvani.newsapijetpackcompose.nav.Destinations.HOME

object Destinations{
    const val HOME = "home"
}

class Action(navController: NavController){
    val home : () -> Unit = { navController.navigate(HOME) }

}

//TODO 42 - Create Sealed Class for item Navigation Page
sealed class Screen(
    val route : String,
    @StringRes val resourceId : Int,
    @DrawableRes val drawableId : Int
){
    object Home : Screen("home", R.string.article,R.drawable.ic_article)

    object Saved : Screen("Saved",R.string.saved,R.drawable.ic_bookmark)
}