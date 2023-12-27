package com.example.databaseonline.ui.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.databaseonline.modeldata.Kontak
import com.example.databaseonline.repositori.KontakRepositori
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed class KontakUIState{
    data class Success(val kontak: List<Kontak>):KontakUIState()
    object Error: KontakUIState()
    object Loading : KontakUIState()
}

class HomeViewModel (private val kontakRepositori: KontakRepositori) : ViewModel(){
    var kontakUIState:KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set

    init {
        getKontak()
    }
    fun getKontak(){
        viewModelScope.launch {
            kontakUIState = KontakUIState.Loading
            kontakUIState = try {
                KontakUIState.Success(kontakRepositori.getKontak())
            }catch (e: IOException){
                KontakUIState.Error
            }catch (e: HttpException){
                KontakUIState.Error
            }
        }
    }
    fun deleteKontak(id: Int){
        viewModelScope.launch{
            try {
                kontakRepositori.deleteKontak(id)
            }catch (e:IOException){
                KontakUIState.Error
            }catch (e:HttpException){
                KontakUIState.Error
            }
        }
    }
}

