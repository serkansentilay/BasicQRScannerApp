package com.serkan.basicbarcodeapp.Rooms

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Barcodedata::class], version = 1, exportSchema = false)
abstract class BarcodeDatabase : RoomDatabase() {
        abstract fun getBarcodeDao() : BarcodeDAO

        companion object {
            @Volatile
            private var instance: BarcodeDatabase? = null

            fun getDatabase(context: Context): BarcodeDatabase {
                var tempInstance = instance
                if (tempInstance != null) {
                    return tempInstance
                }
                synchronized(this)
                {
                    val instance =
                        Room.databaseBuilder(context, BarcodeDatabase::class.java, "urunlerx_db")

                            .build()
                    tempInstance = instance
                    return instance
                }
            }


        }}





















