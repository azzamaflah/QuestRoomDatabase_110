package com.example.pammmm.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pammmm.data.dao.MahasiswaDao
import com.example.pammmm.data.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {

    // mendefinisikan fungsi untuk mengakses data mahasiswa
    abstract fun  mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile // Memastikan bahwa nilai variable instance selalu sama di semua thread
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, //class database
                    "KrsDatabase" //nama database

                )

                    .build().also { Instance = it }

            })
        }
    }
}