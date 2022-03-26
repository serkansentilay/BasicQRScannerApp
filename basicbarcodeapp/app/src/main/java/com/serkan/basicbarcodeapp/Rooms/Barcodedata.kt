package com.serkan.basicbarcodeapp.Rooms

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName="urunler_items")
data class Barcodedata(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val qrbarcode:String,
    val urunadi:String,
    val urunadedi:String,
    val urunfiyati:String

) : Parcelable



















