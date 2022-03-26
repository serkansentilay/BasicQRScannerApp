package com.serkan.basicbarcodeapp.Rooms

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BarcodeDAO {

   @Insert(onConflict=OnConflictStrategy.IGNORE)
   suspend fun addUrun(urun:Barcodedata)

   @Delete
   suspend fun deleteUrun(urun:Barcodedata)

   @Update
   suspend fun updateUrun(urun: Barcodedata)

   @Query("SELECT * FROM urunler_items ORDER BY id DESC")
   fun getAllUrunler(): LiveData<List<Barcodedata>>





}