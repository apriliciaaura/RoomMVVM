package com.example.roommvvm.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

import com.example.roommvvm.R
import com.example.roommvvm.viewmodel.NewStudentViewModel
import kotlinx.android.synthetic.main.fragment_new_name.*

/**
 * A simple [Fragment] subclass.
 */
class NewNameFragment : Fragment() { // Membuat kelas fragment

    private var listener: OnFragmentInteractionListener? = null // Membuat objek untuk listener
    private lateinit var mViewModel: NewStudentViewModel // Membuat objek untuk model

    override fun onCreate(savedInstanceState: Bundle?) { // Dipanggil saat sebuah fragment dibuat
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(NewStudentViewModel::class.java)
    }

    override fun onCreateView( // Dipanggil saat fragment sudah siap membaca sebuah layout.
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_name, container, false) // Mengembangkan tata letak untuk fragmen ini
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) { // Dipanggil setelah onCreateView() dan memastikan layout yang dibaca fragment adalah non-null. Semua pengaturan view seperti pembacaan findViewById, menambah onClickListener dapat dilakukan di sini.
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            val input = editText.text.toString().trim()

            if (input.isEmpty()) { // Jika inputan kosong akan muncul notifikasi pesan toast "nama dibutuhkan"
                Toast.makeText(activity, "Nama dibutuhkan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (input.length > 30) { // Jika panjang inputan lebih dari 30 karakter akan muncul notifikasi pesan toast "nama terlalu panjang"
                Toast.makeText(activity, "Nama terlalu panjang", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mViewModel.storeMovie(input)

            Toast.makeText(activity, "$input entered", Toast.LENGTH_SHORT).show() // Jika data berhasil dimasukkan akan muncul notifikasi pesan toast "input entered", dan data akan beralih ke halaman list
            listener?.goToStudentListFragment()
        }
    }

    override fun onAttach(context: Context) { // Dipanggil saat sebuah instance fragment terhubung dengan sebuah activity.
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() { // Dipanggil saat fragment tidak lagi terhubung ke sebuah activity.
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener { // Dipanggil saat terdapat interaksi fragment
        fun goToStudentListFragment()
    }

    companion object { // Sebuah fungsi atau member variabel di suatu kelas agar bisa dipanggil tanpa melalui sebuah objek. Digunakan jika ada variabel/function yang sering digunakan berulang-ulang.
        @JvmStatic
        fun newInstance() = NewNameFragment()
    }
}
