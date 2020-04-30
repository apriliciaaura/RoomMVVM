package com.example.roommvvm.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // Mewakili tabel SQLite untuk merepresentasikan tabel Student pada Database.
data class Student ( // Fungsi untuk membuat tabel baru dengan nama "Student"
    @PrimaryKey(autoGenerate = true) var id: Int? = null, // Setiap entitas membutuhkan kunci utama karena setiap Student id-nya pasti berbeda-beda. Untuk Primary Key didalam Room Database kita juga dapat membuat autoGenerate id seperti ini @PrimaryKey(autoGenerate = true) yang secara otomatis akan membuat id-nya sendiri sehingga tipe data dibiarkan null / kosong.

    @ColumnInfo var name: String = "" // Ditambahkan jika ingin kolom memiliki nama yang berbeda.
)
