package com.example.databaseonline.service_api

import com.example.databaseonline.modeldata.Kontak
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("/kontak")
    suspend fun getKontak(): List<Kontak>

    @DELETE("kontak/{id}")
    suspend fun deleteKontak(@Path("id") id: Int): Response<Void>
}