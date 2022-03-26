package com.serkan.basicbarcodeapp.Fragments.tara

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.zxing.Result
import com.serkan.basicbarcodeapp.Fragments.urunler.Urunler_DetayFragment
import com.serkan.basicbarcodeapp.R
import com.serkan.basicbarcodeapp.databinding.FragmentTaraBinding
import kotlinx.android.synthetic.main.fragment_tara.view.*
import me.dm7.barcodescanner.zxing.ZXingScannerView


class TaraFragment : Fragment(),ZXingScannerView.ResultHandler {

    private lateinit var mView:View
    private lateinit var scanner: ZXingScannerView
    private var _binding:FragmentTaraBinding?=null
    private val binding get()=_binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mView= inflater.inflate(R.layout.fragment_tara, container, false)

        tara()


        return mView.rootView
    }




    private fun tara(){
        scanner = ZXingScannerView(requireContext())
        scanner.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.gray))
        scanner.setBorderColor(ContextCompat.getColor(requireContext(),R.color.blue))
        scanner.setLaserColor(ContextCompat.getColor(requireContext(),R.color.red))
        scanner.setBorderStrokeWidth(10)
        scanner.setAutoFocus(true)
        scanner.setSquareViewFinder(true)
        scanner.setResultHandler(this)
        mView.framescanner.addView(scanner)
        taramayabasla()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun taramayabasla(){
        scanner.startCamera()
    }

    override fun onResume() {
        super.onResume()
        scanner.setResultHandler (this)
        scanner.startCamera()

    }

    override fun onPause() {
        super.onPause()
        scanner.stopCamera()
    }

    override fun onDestroy() {
        super.onDestroy()
        scanner.stopCamera()
        _binding = null
    }


    override fun handleResult(p0: Result?) {
        if(p0!=null){
           val bundle = Bundle()
            bundle.putString("bc",p0.text)
            val fragment = Urunler_DetayFragment()
            fragment.arguments=bundle
            fragmentManager?.beginTransaction()?.replace(R.id.fragment,fragment)?.commit()
        }
        scanner.resumeCameraPreview(this)

    }


}