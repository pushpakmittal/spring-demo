package com.myapp.spring_demo.service;

import com.myapp.spring_demo.adapter.IExternalServiceAdapter;
import com.myapp.spring_demo.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student addStudent(Student student, IExternalServiceAdapter externalServiceAdapter);
}
