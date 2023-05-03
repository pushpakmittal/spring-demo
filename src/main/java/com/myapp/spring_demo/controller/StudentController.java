package com.myapp.spring_demo.controller;

import com.myapp.spring_demo.model.Student;
import com.myapp.spring_demo.factory.ExternalServiceFactory;
import com.myapp.spring_demo.adapter.IExternalServiceAdapter;
import com.myapp.spring_demo.model.IntegrationType;
import com.myapp.spring_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    private IExternalServiceAdapter externalServiceAdapter;

    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        externalServiceAdapter = ExternalServiceFactory.getApiService(IntegrationType.DUMMY_SERVICE_ONE); //integrationType can come from request also
        Student savedStudent = studentService.addStudent(student, externalServiceAdapter);
        return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
    }

}


