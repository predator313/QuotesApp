package com.example.quotesappcompose.navigation

import android.util.Log
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.quotesappcompose.DataManager
import com.example.quotesappcompose.QuotesDetailsScreen
import com.example.quotesappcompose.QuotesModel
import com.example.quotesappcompose.QuotesScreen
import kotlin.reflect.typeOf

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun QuoteNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController() //navHostController when we need to play with the graph
) {
    SharedTransitionLayout {
        NavHost(navController = navController, startDestination = QuotesScreen ) {
            composable<QuotesScreen> {
                if(DataManager.isDataLoaded.value) {
                    QuotesScreen(DataManager.data,modifier = modifier) {
                        navController.navigate(QuotesDetailsScreen(it))
                        Log.e("hello","clicked ${it.quotes}")
                    }

                }
            }
            composable<QuotesDetailsScreen>(
                typeMap = mapOf(
                    typeOf<QuotesModel>() to CustomNavType.quoteModelNavDc
                )
            ) {
                val arguments = it.toRoute<QuotesDetailsScreen>()

                QuotesDetailsScreen(arguments.quotesModel, modifier = Modifier){
                    navController.navigateUp()
                }

            }
        }
    }
}
