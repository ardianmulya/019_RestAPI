package com.example.databaseonline

import android.app.Application
import com.example.databaseonline.repositori.AppContainer
import com.example.databaseonline.repositori.KontakContainer

class KontakApplication :Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}