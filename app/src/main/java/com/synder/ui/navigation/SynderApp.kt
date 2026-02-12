package com.synder.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.synder.ui.components.GlassTopBar

@Composable
fun SynderApp(permissionGranted: Boolean) {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        topBar = {
            GlassTopBar(
                title = if (permissionGranted) "Synder" else "Synder (Limited)",
                subtitle = "Discover your next obsession"
            )
        },
        containerColor = Color.Transparent,
        bottomBar = {
            NavigationBar(
                containerColor = Color.White.copy(alpha = 0.08f),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .blur(8.dp)
                    .background(
                        color = Color.White.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(24.dp)
                    )
            ) {
                listOf(BottomNavItem.Explore, BottomNavItem.Library, BottomNavItem.Profile)
                    .forEach { item ->
                        NavigationBarItem(
                            selected = backStack?.destination?.route == item.route,
                            onClick = { navController.navigate(item.route) },
                            icon = { Icon(item.icon, contentDescription = item.label) },
                            label = { Text(item.label) }
                        )
                    }
            }
        }
    ) { innerPadding ->
        SynderNavGraph(navController = navController, innerPadding = innerPadding)
    }
}
