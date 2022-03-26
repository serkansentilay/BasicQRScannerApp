package com.serkan.basicbarcodeapp.Rooms

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class BarcodeRepository (private val barcodeDao:BarcodeDAO) {
    val getAllUrun:LiveData<List<Barcodedata>> = barcodeDao.getAllUrunler()
    suspend fun addUrun(urun:Barcodedata){
        barcodeDao.addUrun(urun)
    }
    suspend fun updateUrun(urun:Barcodedata){
        barcodeDao.updateUrun(urun)
    }
    suspend fun deleteUrun(urun:Barcodedata){
        barcodeDao.deleteUrun(urun)
    }


}