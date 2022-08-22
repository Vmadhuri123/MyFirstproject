package com.example.studentinformation

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDao {
    @Query("SELECT * fROM student_details")
    fun getAll():List<User>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student:User)
    @Query("DELETE FROM student_details")
    suspend fun deleteAll()

}