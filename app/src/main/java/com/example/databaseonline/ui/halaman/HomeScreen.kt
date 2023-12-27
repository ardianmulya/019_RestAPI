package com.example.databaseonline.ui.halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.databaseonline.navigation.DestinasiNavigasi
import com.example.databaseonline.ui.view_model.HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.databaseonline.ui.PenyediaViewModel

object DetinasiHome : DestinasiNavigasi{
    override val route = "home"
    override val titleres = "Kontak"

}


