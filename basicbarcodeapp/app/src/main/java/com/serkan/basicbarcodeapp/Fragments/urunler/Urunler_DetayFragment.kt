package com.serkan.basicbarcodeapp.Fragments.urunler

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.serkan.basicbarcodeapp.Adapters.BarcodeUrunlerAdapter
import com.serkan.basicbarcodeapp.Fragments.tara.TaraFragment
import com.serkan.basicbarcodeapp.R
import com.serkan.basicbarcodeapp.Rooms.BarcodeDatabase
import com.serkan.basicbarcodeapp.Rooms.BarcodeViewModel
import com.serkan.basicbarcodeapp.Rooms.Barcodedata
import com.serkan.basicbarcodeapp.databinding.FragmentUrunlerDetayBinding
import java.util.zip.Inflater


class Urunler_DetayFragment : Fragment() {

   private lateinit var  barcodeViewModel:BarcodeViewModel

    private var _binding: FragmentUrunlerDetayBinding? = null
    private val binding get() = _binding!!
  //  private val myarg by navArgs<UrunlerDetayFragmentArgs>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUrunlerDetayBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.urundetay_item,menu)

    }
/*
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menu_delete){
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("${myarg.currentUrun.urunadi} silenecek")
            builder.setMessage("Silmek istiyor musunuz?")
            builder.setPositiveButton("Evet"){_,_ ->
                barcodeViewModel.deleteUrun(myarg.currentUrun)
                Toast.makeText(context,"Ürün Silindi",Toast.LENGTH_SHORT).show()
                

            }
            builder.setNegativeButton("Hayır"){_,_ ->

            }
        }

        return super.onOptionsItemSelected(item)
    }

*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val arg = this.arguments
            val inputData=arg?.get("bc")
            binding.urunbarkod.text = inputData.toString()

       /*     //bundle ile ekleyeceğiz
            binding.urunadi.setText(myarg.currentUrun.urunadi)
            binding.urunadedi.setText(myarg.currentUrun.urunadedi)
            binding.urunfiyati.setText(myarg.currentUrun.urunfiyati)
*/

        }


        setHasOptionsMenu(true)




     //   if(binding.urunbarkod.text.isNotEmpty()){
            //texttte barkod varsa roomdan onun verilerini getirelim
     //   }




        barcodeViewModel = ViewModelProvider(this).get(BarcodeViewModel::class.java)





        val fragment = TaraFragment()
        binding.barkodtara.setOnClickListener {
            fragmentManager?.beginTransaction()?.apply {
                replace(R.id.fragment, fragment, TaraFragment::class.java.simpleName)
                    .addToBackStack(null)
                    .commit()

            }


        }



        binding.urunkaydet.setOnClickListener {
            val urun = Barcodedata(0,
                binding.urunbarkod.text.toString(),
                binding.urunadi.text.toString(),
                binding.urunadedi.text.toString(),
                binding.urunfiyati.text.toString()
            )
            barcodeViewModel.addUrun(urun)
            Toast.makeText(context,"Ürün Eklendi",Toast.LENGTH_SHORT).show()




        }
/*
        binding.urunguncelle.setOnClickListener {
            val updateUrun = Barcodedata(myarg.currentUrun.id,
            binding.urunbarkod.text.toString(),
            binding.urunadi.text.toString(),
            binding.urunadedi.text.toString(),
            binding.urunfiyati.text.toString())

            barcodeViewModel.updateUrun(updateUrun)
            Toast.makeText(context,"Ürün Güncellendi",Toast.LENGTH_SHORT).show()

        }
*/


        binding.sepeteekle.setOnClickListener {
            //girilmiş değer olanı sepete ekleyecek
        }






    }


}






















