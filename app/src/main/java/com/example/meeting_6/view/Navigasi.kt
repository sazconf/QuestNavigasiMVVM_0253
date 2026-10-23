package com.example.meeting_6.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class Navigasi {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.FormulirSaya.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.FormulirSaya.name) {
                FormIsian(
                    //pilihanJK = JenisK.map { id -> konteks.resources
                    //    .getString(id) },
                    OnSubmitBtnClick = {
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            
            composable(route = Navigasi.Detail.name) {
                TampilData(
                    onBackBtnClick = { cancelAndBackToFormulirSaya(navController) }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulirSaya(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.FormulirSaya.name, inclusive = false)
}
