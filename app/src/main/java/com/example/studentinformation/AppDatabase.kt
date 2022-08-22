package com.example.studentinformation

import android.content.Context
import androidx.room.*
import kotlinx.coroutines.InternalCoroutinesApi


@Database(entities = [User::class], version =1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun studentDao():StudentDao
    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = Instance
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
             val instance= Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,
                 "attend_database").build()
                Instance=instance
                return instance
            }

        }

    }



}