package com.sandip.roomdemoapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sandip.roomdemoapp.repository.StudentRepository
import java.lang.IllegalArgumentException

class StudentViewModelFactory(private val studentRepository: StudentRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentViewModel::class.java)) {
            return StudentViewModel(studentRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}