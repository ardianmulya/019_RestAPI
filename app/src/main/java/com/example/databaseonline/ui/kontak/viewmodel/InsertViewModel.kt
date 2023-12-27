package com.example.databaseonline.ui.kontak.viewmodel

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.databaseonline.modeldata.Kontak
import com.example.databaseonline.repositori.KontakRepositori

class InsertViewModel (private val kontakRepositori: KontakRepositori):ViewModel(){
    var insertKontakState by mutableStateOf(InsertUiState())
        private set
}

data class  InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent(),
)

data class InsertUiEvent(
    val id: Int = 0,
    val nama : String = "",
    val email: String = "",
    val nohp: String = ""
)

fun InsertUiEvent.toKontak(): Kontak = Kontak(
    id = id,
    nama = nama,
    alamat = email,
    telpon = nohp
)

fun Kontak.toUiStateKontak(): InsertUiState = InsertUiState(
    insertUiEvent = toInserUiEvent()
)
fun Kontak.toInserUiEvent(): InsertUiEvent = InsertUiEvent(
    id = id,
    nama = nama,
    email = alamat,
    nohp = telpon
)