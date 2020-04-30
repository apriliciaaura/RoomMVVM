package com.example.roommvvm.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roommvvm.entity.Student

@Dao // Mengidentifikasi sebagai kelas DAO untuk Room, juga untuk membuat objek akses data dalam database menggunakan kelas interface.
interface StudentDao { // Merupakan sebuah interface, DAO harus berupa interface atau kelas abstrak.
    @Query("Select * from student") // @Query = Anotasi utama yang digunakan dalam class DAO. Metode ini memungkinkan untuk melakukan operasi baca/tulis pada database. "Select * from student" =  Metode untuk mengambil semua field tabel dari Student.
    fun getAll(): List<Student> // Metode untuk mendapatkan semua data Student dan mengembalikannya ke List.

    @Insert
    fun insertStudent(item: Student) // Metode yang digunakan untuk menambahkan data baru pada database, untuk itu kita perlu menggunakan Annotation @Insert.
}