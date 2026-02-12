package com.synder

import android.Manifest
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import android.content.pm.PackageManager
import com.synder.ui.navigation.SynderApp
import com.synder.ui.theme.SynderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val requestPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SynderTheme {
                val permissionGranted = remember { mutableStateOf(false) }
                val context = LocalContext.current

                LaunchedEffect(Unit) {
                    val hasPermission = ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.INTERNET
                    ) == PackageManager.PERMISSION_GRANTED
                    permissionGranted.value = hasPermission

                    if (!hasPermission && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermission.launch(Manifest.permission.INTERNET)
                    }
                }

                SynderApp(permissionGranted = permissionGranted.value)
            }
        }
    }
}
