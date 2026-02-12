package com.synder.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.synder.ui.screens.explore.ExploreScreen
import com.synder.ui.screens.library.LibraryScreen
import com.synder.ui.screens.profile.ProfileScreen

@Composable
fun SynderNavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Explore.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Explore.route) { ExploreScreen(innerPadding) }
        composable(BottomNavItem.Library.route) { LibraryScreen(innerPadding) }
        composable(BottomNavItem.Profile.route) { ProfileScreen(innerPadding) }
    }
}
