package com.serkan.basicbarcodeapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textview.MaterialTextView
import com.serkan.basicbarcodeapp.Fragments.urunler.UrunlerFragmentDirections
import com.serkan.basicbarcodeapp.R

import com.serkan.basicbarcodeapp.Rooms.Barcodedata

class BarcodeUrunlerAdapter:RecyclerView.Adapter<BarcodeUrunlerAdapter.MyViewHolder>()    {
        private var urunList = emptyList<Barcodedata>()

    class MyViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val txtUrunbarcode = view.findViewById<TextView>(R.id.urunbarkod)
        val txtUrunadi = view.findViewById<TextView>(R.id.urunadi)
        val txtUrunadedi = view.findViewById<TextView>(R.id.urunadedi)
        val txtUrunfiyati = view.findViewById<TextView>(R.id.urunfiyati)

            fun bind(urun:Barcodedata){
                txtUrunbarcode.setText(urun.qrbarcode)
                txtUrunadi.setText(urun.urunadi)
                txtUrunadedi.setText("ADET "+urun.urunadedi)
                txtUrunfiyati.setText("FİYAT "+urun.urunfiyati+" TL")

                }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.urunler_rv_item,parent,false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentUrun = urunList.get(position)
            holder.bind(currentUrun)
            holder.itemView.setOnClickListener {
               val action= UrunlerFragmentDirections.actionUrunlerFragmentToUrunlerDetayFragment(currentUrun)
                holder.itemView.findNavController().navigate(action)
            }
        }

        override fun getItemCount(): Int {
            return urunList.size
        }

    fun setUrun(urunList:List<Barcodedata>){
        this.urunList=urunList
        notifyDataSetChanged()
    }


    }



































