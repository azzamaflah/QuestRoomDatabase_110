package com.example.pammmm.dependeciesinjection

import android.content.Context
import com.example.pammmm.data.database.KrsDatabase
import com.example.pammmm.repository.LocalRepositoryMhs
import com.example.pammmm.repository.RepositoryMhs


interface InterfaceContainerApp{
    val repositoryMhs: RepositoryMhs
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
    override val repositoryMhs: RepositoryMhs by lazy { 
        LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
    }
        
}