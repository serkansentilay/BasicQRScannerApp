package com.serkan.basicbarcodeapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.serkan.basicbarcodeapp.Fragments.sepet.SepetFragment
import com.serkan.basicbarcodeapp.Fragments.tara.TaraFragment
import com.serkan.basicbarcodeapp.Fragments.urunler.UrunlerFragment
import com.serkan.basicbarcodeapp.Fragments.urunler.Urunler_DetayFragment
import com.serkan.basicbarcodeapp.R
import com.serkan.basicbarcodeapp.databinding.ActivityMainBinding
import com.serkan.basicbarcodeapp.databinding.FragmentUrunlerBinding
import com.serkan.basicbarcodeapp.databinding.FragmentUrunlerDetayBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_urunler.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding



        val urunlerfragment = UrunlerFragment()
    val tarafragment = TaraFragment()
    val sepetFragment = SepetFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(urunlerfragment)
        binding.bottomnav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.urunler -> replaceFragment(urunlerfragment)
                R.id.tara -> replaceFragment(tarafragment)
                R.id.sepet -> replaceFragment(sepetFragment)
            }
            true
        }






    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment,fragment)
            commit()
        }
    }





}