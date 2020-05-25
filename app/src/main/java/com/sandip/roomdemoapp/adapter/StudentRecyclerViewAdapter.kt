package com.sandip.roomdemoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sandip.roomdemoapp.R
import com.sandip.roomdemoapp.databinding.StudentListChildBinding
import com.sandip.roomdemoapp.db.Student

class StudentRecyclerViewAdapter :
    RecyclerView.Adapter<StudentRecyclerViewAdapter.StudentViewHolder>() {

    private val studentList= ArrayList<Student>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val studentListBinding: StudentListChildBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.student_list_child, parent, false)
        return StudentViewHolder(studentListBinding)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bindData(studentList.get(position))
    }

    fun setData(student: List<Student>) {
        studentList.clear()
        studentList.addAll(student)
    }

    class StudentViewHolder(private val studentListChildBinding: StudentListChildBinding) :
        RecyclerView.ViewHolder(studentListChildBinding.root) {

        fun bindData(student: Student) {
            studentListChildBinding.tvStudentName.text = student.studentName
            studentListChildBinding.tvStudentEmail.text = student.studentEmail
            studentListChildBinding.tvStudentCountry.text = student.studentCountry
            studentListChildBinding.tvDate.text = "10 Oct 1987"
        }
    }
}