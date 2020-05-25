package com.sandip.roomdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sandip.roomdemoapp.databinding.ActivityAddStudentBinding
import com.sandip.roomdemoapp.db.StudentDatabase
import com.sandip.roomdemoapp.repository.StudentRepository
import com.sandip.roomdemoapp.viewModel.StudentViewModel
import com.sandip.roomdemoapp.viewModel.StudentViewModelFactory

class AddStudentActivity : AppCompatActivity() {

    private lateinit var activityAddStudentBinding: ActivityAddStudentBinding
    private lateinit var studentViewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityAddStudentBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_student)

        val studentDao = StudentDatabase.getInstance(application).studentDao
        val studentRepository = StudentRepository(studentDao)
        val studentViewModelFactory = StudentViewModelFactory(studentRepository)

        studentViewModel = ViewModelProvider(this, studentViewModelFactory).get(StudentViewModel::class.java)

        activityAddStudentBinding.lifecycleOwner = this
        activityAddStudentBinding.studentViewModel = studentViewModel
    }

    fun addStudent(view: View) {
        studentViewModel.addStudent()
        finish()
    }
}
