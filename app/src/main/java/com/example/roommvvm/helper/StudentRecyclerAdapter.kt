package com.example.roommvvm.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.R
import com.example.roommvvm.entity.Student

class StudentRecyclerAdapter(private val myDataset: List<Student>):
        RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() { // StudentRecycleAdapter menghubungkan data dengan RecyclerView. Adapter menyiapkan data dan cara untuk menampilkan data dalam view holder. Bila data berubah, adapter akan memperbarui materi tampilan item daftar terkait dalam RecyclerView. Adapter menggunakan ViewHolder untuk menampung tampilan yang menyusun setiap item dalam RecyclerView, dan mengikat data untuk ditampilkan dalam tampilan yang menampilkannya.

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { // RecyclerView.ViewHolder menjelaskan tampilan data dan metadata tentang tempatnya dalam RecyclerView. Setiap view holder menampung satu rangkaian data. Adapter menambahkan data ke view holder untuk ditampilkan oleh pengelola layout.
        var tvName: TextView = itemView.findViewById(R.id.tvName) // Menampilkan textview Nama
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder { // Berisi tampilan informasi untuk menampilkan satu item dari layout item. Ini memperluas tampilan item dan mengembalikan view holder baru yang memuatnya. Metode ini digunakan oleh adapter untuk menyediakan data.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false) // Menjadikan atau mengconvert file layout xml sebagai view object baru di dalam layout utama.

        return StudentViewHolder(v) // Mengembalikan nilai agar dapat diolah pada proses berikutnya.
    }

    override fun getItemCount(): Int { // Mengembalikan jumlah item data yang tersedia untuk ditampilkan.
        return myDataset.size // Mengembalikan nilai agar dapat diolah pada proses berikutnya.
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) { // Menyetel materi item pada posisi yang ditentukan dalam RecyclerView. Proses ini dipanggil oleh RecyclerView, misalnya bila sebuah item baru bergulir ke tampilan.
        holder.tvName.text = myDataset[position].name // Menampilkan data nama
    }
}
