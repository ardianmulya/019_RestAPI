package com.example.databaseonline.ui

import android.text.Spannable.Factory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.databaseonline.KontakApplication
import com.example.databaseonline.ui.kontak.viewmodel.InsertViewModel
import com.example.databaseonline.ui.view_model.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiMars().container.kontakRepositori)
        }
        initializer {
            InsertViewModel(aplikasiMars().container.kontakRepositori)
        }
    }
}

fun CreationExtras.aplikasiMars():KontakApplication = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as KontakApplication)