package com.serkan.basicbarcodeapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.serkan.basicbarcodeapp.R
import com.serkan.basicbarcodeapp.Rooms.Barcodedata

class BarcodeSepetAdapter: RecyclerView.Adapter<BarcodeSepetAdapter.MyViewHolder>() {

    private var urunList = emptyList<Barcodedata>()

    class MyViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val txtUrunadi = view.findViewById<TextView>(R.id.urunadi)
        val txtUrunadedi = view.findViewById<TextView>(R.id.urunadedi)
        val txtUrunfiyati = view.findViewById<TextView>(R.id.urunfiyati)

        fun bind(urun:Barcodedata){
            txtUrunadi.setText(urun.urunadi)
            txtUrunadedi.setText("ADET "+urun.urunadedi)
            txtUrunfiyati.setText("FİYAT "+urun.urunadedi.toInt()*urun.urunfiyati.toInt()+" TL")

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sepet_rv_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUrun = urunList.get(position)
        holder.bind(currentUrun)
    }

    override fun getItemCount(): Int {
        return urunList.size
    }

    fun setUrun(urunList:List<Barcodedata>){
        this.urunList=urunList
        notifyDataSetChanged()
    }

}





















