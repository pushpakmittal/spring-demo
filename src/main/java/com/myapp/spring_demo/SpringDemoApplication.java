package com.myapp.spring_demo;

import com.myapp.spring_demo.service.impl.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class SpringDemoApplication implements CommandLineRunner {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    public void run(String... args) throws Exception {
//        Student student = Student.builder()
//                .name("pushpak")
//                .age(25)
//                .build();
//        studentService.addStudent(student);
//        List<Student> students = studentService.getAllStudents();
//        log.info("student list : " + students);
    }

    @Scheduled(cron = "0 0 0 ? * * *")
    public void job() {
        System.out.println("welcome");
    }

}
