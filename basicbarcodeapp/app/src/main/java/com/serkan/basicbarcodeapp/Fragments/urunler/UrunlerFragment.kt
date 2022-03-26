package com.serkan.basicbarcodeapp.Fragments.urunler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.serkan.basicbarcodeapp.Adapters.BarcodeUrunlerAdapter
import com.serkan.basicbarcodeapp.R
import com.serkan.basicbarcodeapp.Rooms.*
import com.serkan.basicbarcodeapp.databinding.FragmentUrunlerBinding
import com.serkan.basicbarcodeapp.utils.onQueryTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_urunler.*


class UrunlerFragment : Fragment(){

    private lateinit var barcodeUAdapter:BarcodeUrunlerAdapter
    private lateinit var barcodeViewModel:BarcodeViewModel
    private var _binding:FragmentUrunlerBinding?=null
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding= FragmentUrunlerBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val arg = this.arguments
            val inputData=arg?.get("bcsearch")

        }







      barcodeViewModel = ViewModelProvider(this).get(BarcodeViewModel::class.java)

        val recyclerView=view.findViewById<RecyclerView>(R.id.recyclerurunler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        barcodeUAdapter = BarcodeUrunlerAdapter()
        recyclerView.adapter = barcodeUAdapter
        barcodeViewModel.getAllData.observe(viewLifecycleOwner, Observer { urunList ->
            barcodeUAdapter.setUrun(urunList)
            if(urunList.size==0){
                Toast.makeText(context,"LİSTE BOŞ",Toast.LENGTH_SHORT).show()
            }

        })




       val fragment = Urunler_DetayFragment()
        binding.urunekle.setOnClickListener {
          fragmentManager?.beginTransaction()?.apply {
               replace(R.id.fragment,fragment,Urunler_DetayFragment::class.java.simpleName)
                   .addToBackStack(null)
                   .commit()
           }


        }

        binding.searchimage.setOnClickListener {
            //kameraya basınca tarayarak arayacak
        }



    }





}















