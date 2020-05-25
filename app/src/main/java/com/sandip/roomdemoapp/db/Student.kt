package com.sandip.roomdemoapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "student_id")
    val studentId: Int,

    @ColumnInfo(name = "student_name")
    val studentName: String,

    @ColumnInfo(name = "student_email")
    val studentEmail: String,

    @ColumnInfo(name = "student_country")
    val studentCountry: String
)