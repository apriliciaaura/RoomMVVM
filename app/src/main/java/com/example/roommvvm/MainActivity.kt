package com.example.roommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roommvvm.fragment.NameListFragment
import com.example.roommvvm.fragment.NewNameFragment
import timber.log.Timber

class MainActivity : AppCompatActivity(),
    NewNameFragment.OnFragmentInteractionListener, // Memanggil objek NewNameFragment
    NameListFragment.OnFragmentInteractionListener{ // Memanggil objek NameListFragment

    override fun onCreate(savedInstanceState: Bundle?) { // Method ini dieksekusi saat pertama kali Activity dijalankan. Dimana di method ini kita men set-up semua komponen Activity, seperti menset-up interfacenya
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {  // Jika tidak ada proses, diarahkan ke halaman StudentListFragment
            goToStudentListFragment()
        }

        Timber.plant(Timber.DebugTree()) // Mengelola logging
    }

    override fun goToStudentListFragment() { // Fungsi untuk menuju ke halaman StudentListFragment
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.flContent, NameListFragment.newInstance())
        transaction.commit()
    }

    override fun goToNewNameFragment() { // Fungsi untuk menuju ke halaman NewNameFragment
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.flContent, NewNameFragment.newInstance())
        transaction.commit()
    }
}
