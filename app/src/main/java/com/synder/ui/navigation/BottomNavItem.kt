package com.synder.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Explore
import androidx.compose.material.icons.rounded.LibraryMusic
import androidx.compose.material.icons.rounded.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    data object Explore : BottomNavItem("explore", Icons.Rounded.Explore, "Explore")
    data object Library : BottomNavItem("library", Icons.Rounded.LibraryMusic, "Library")
    data object Profile : BottomNavItem("profile", Icons.Rounded.Person, "Profile")
}
