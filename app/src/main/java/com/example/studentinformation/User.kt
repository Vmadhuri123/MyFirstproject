package com.example.studentinformation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName="Student_Details")
data class User(
    @PrimaryKey(autoGenerate = true) val id:Int?,
    @ColumnInfo(name="firstname") val firstname:String?,
    @ColumnInfo(name="lastname")    val lastname:String?,
    @ColumnInfo(name="email")    val email:String?,
    @ColumnInfo(name="password")  val password:String?,
    @ColumnInfo(name="admin")  val admin:Boolean?
)
