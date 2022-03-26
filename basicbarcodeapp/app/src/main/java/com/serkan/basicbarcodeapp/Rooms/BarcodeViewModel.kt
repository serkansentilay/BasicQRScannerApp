package com.serkan.basicbarcodeapp.Rooms

import android.app.Application
import android.provider.Settings
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class BarcodeViewModel(application: Application):AndroidViewModel(application) {


    val getAllData:LiveData<List<Barcodedata>>
    private val repository:BarcodeRepository

  init {
      val urunDao = BarcodeDatabase.getDatabase(application).getBarcodeDao()
      repository = BarcodeRepository(urunDao)
      getAllData=urunDao.getAllUrunler()
  }
    fun addUrun(urun:Barcodedata){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUrun(urun)
        }
    }
    fun updateUrun(urun:Barcodedata){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUrun(urun)
        }
    }
    fun deleteUrun(urun:Barcodedata){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUrun(urun)
        }
    }




}


















