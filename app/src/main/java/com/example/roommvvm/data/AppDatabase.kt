package com.example.roommvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roommvvm.dao.StudentDao
import com.example.roommvvm.entity.Student

@Database(entities = arrayOf(Student::class), version = 1) // Basis data dibuat oleh kelas abstrak, dianotasikan dengan @Database dan memperluas kelas RoomDatabase. Juga, entitas yang akan dikelola oleh database harus dilewatkan dalam array di properti entities dalam penjelasan @Database.
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object { // Sebuah fungsi atau member variabel di suatu kelas agar bisa dipanggil tanpa melalui sebuah objek. Digunakan jika ada variabel/function yang sering digunakan berulang-ulang.
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? { // Digunakan saat sebuah context dibutuhkan diluar siklus hidup sebuah komponen atau activity, atau saat komponen tersebut tidak tergantung pada siklus hidup context yang diterimanya.
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "student-database")
                        .build()
                }
            }
            return INSTANCE // Digunakan untuk mengembalikan nilai agar dapat diolah pada proses berikutnya.
        }

        fun destroyInstance() { // Digunakan untuk mengakhiri proses.
            INSTANCE = null
        }
    }
}