package com.sandip.roomdemoapp.repository

import com.sandip.roomdemoapp.db.Student
import com.sandip.roomdemoapp.db.StudentDao

class StudentRepository(private val studentDao: StudentDao) {

    val studentList = studentDao.getAllStudents()

    suspend fun insertStudent(student: Student) {
        studentDao.insertStudent(student)
    }

    suspend fun updateStudent(student: Student) {
        studentDao.updateStudent(student)
    }

    suspend fun deleteStudent(student: Student) {
        studentDao.deleteStudent(student)
    }
}