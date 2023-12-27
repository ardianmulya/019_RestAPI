package com.example.databaseonline.ui.halaman

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.example.databaseonline.navigation.DestinasiNavigasi
import com.example.databaseonline.ui.view_model.HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.databaseonline.ui.PenyediaViewModel
import com.example.databaseonline.ui.TopAppBar

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleres = "Kontak"

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (Int) -> Unit = {},
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = DestinasiHome.titleres,
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Kontak")
            }
        },
    ){
        innerPadding ->

        HomeStatus(
            kontakUIState = viewModel.kontakUIState,
            retryAction = { viewModel.getKontak()},
            modifier = Modifier.padding(innerPadding),
            onDeleteClick = {viewModel.deleteKontak(it.id)
                            viewModel.getKontak()},
            onDetailClick = onDetailClick
        )
    }
}
