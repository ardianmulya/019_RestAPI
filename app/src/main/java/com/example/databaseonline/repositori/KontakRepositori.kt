package com.example.databaseonline.repositori

import com.example.databaseonline.modeldata.Kontak
import com.example.databaseonline.service_api.KontakService

interface KontakRepositori {
    suspend fun getKontak(): List<Kontak>
}

class NetworkKontakRepositori(
    private val kontakApiService: KontakService
) : KontakRepositori {
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
}