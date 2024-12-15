package com.example.pammmm

import android.app.Application
import com.example.pammmm.dependeciesinjection.ContainerApp
import com.example.pammmm.dependeciesinjection.InterfaceContainerApp

class KrsApp : Application() {
    //fungsinya untuk menyinmpan instance ContainerApp
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        //Membuat instance ContainerApp
        containerApp = ContainerApp(this)
        // instance adalah object yang dibuat dari class
    }
}