package com.sandip.roomdemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandip.roomdemoapp.adapter.StudentRecyclerViewAdapter
import com.sandip.roomdemoapp.databinding.ActivityMainBinding
import com.sandip.roomdemoapp.db.StudentDatabase
import com.sandip.roomdemoapp.repository.StudentRepository
import com.sandip.roomdemoapp.viewModel.StudentViewModel
import com.sandip.roomdemoapp.viewModel.StudentViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var studentViewModel: StudentViewModel
    private lateinit var studentRecyclerViewAdapter: StudentRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val studentDao = StudentDatabase.getInstance(application).studentDao
        val studentRepository = StudentRepository(studentDao)
        val studentViewModelFactory = StudentViewModelFactory(studentRepository)

        studentViewModel =
            ViewModelProvider(this, studentViewModelFactory).get(StudentViewModel::class.java)
        activityMainBinding.lifecycleOwner = this
        activityMainBinding.studentViewModel = studentViewModel

        studentRecyclerViewAdapter = StudentRecyclerViewAdapter()
        activityMainBinding.rvStudentList.layoutManager = LinearLayoutManager(this)
        activityMainBinding.rvStudentList.adapter = studentRecyclerViewAdapter

        studentViewModel.studentList.observe(this, Observer {
            Log.v("Main Activity", "Student List Count: " + it.size)
            studentRecyclerViewAdapter.setData(it)
            studentRecyclerViewAdapter.notifyDataSetChanged()
        })

        activityMainBinding.fabAddStudent.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddStudentActivity::class.java))
        }
    }
}
