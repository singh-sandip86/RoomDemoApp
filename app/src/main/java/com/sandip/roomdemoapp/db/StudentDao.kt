package com.sandip.roomdemoapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    suspend fun insertStudent(student: Student)

    @Query("SELECT * FROM student_table")
    fun getAllStudents(): LiveData<List<Student>>

    @Update
    suspend fun updateStudent(student: Student): Int

    @Delete
    suspend fun deleteStudent(student: Student)
}