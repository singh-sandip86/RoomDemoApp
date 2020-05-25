package com.sandip.roomdemoapp.viewModel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandip.roomdemoapp.db.Student
import com.sandip.roomdemoapp.repository.StudentRepository
import kotlinx.coroutines.launch

class StudentViewModel(private val studentRepository: StudentRepository) : ViewModel(), Observable {

    val studentList = studentRepository.studentList

    @Bindable
    val studentName = MutableLiveData<String>()

    @Bindable
    val studentEmail = MutableLiveData<String>()

    @Bindable
    val studentCountry = MutableLiveData<String>()

    fun addStudent() {
        val name = studentName.value!!
        val email = studentEmail.value!!
        val country = studentCountry.value!!

        viewModelScope.launch {
            studentRepository.insertStudent(Student(0, name, email, country))
        }

        studentName.value = null
        studentEmail.value = null
        studentCountry.value = null
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}