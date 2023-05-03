package com.myapp.spring_demo.service.impl;

import com.myapp.spring_demo.adapter.IExternalServiceAdapter;
import com.myapp.spring_demo.model.Student;
import com.myapp.spring_demo.repository.StudentRepository;
import com.myapp.spring_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Value(value = "${DB_FETCH_PAGE_SIZE}")
    private Integer PAGE_SIZE;

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        Page<Student> pagedStudents = studentRepository.findAll(PageRequest.of(0, PAGE_SIZE));
        students.addAll(pagedStudents.getContent());
        while (pagedStudents.hasNext()) {
            students.addAll(studentRepository.findAll(pagedStudents.nextPageable()).getContent());
        }
        return students;
    }

    @Override
    public Student addStudent(Student student, IExternalServiceAdapter externalServiceAdapter) {
        return studentRepository.save(student);
    }
}
