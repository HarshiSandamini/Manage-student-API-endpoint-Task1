package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface StudentService {

    List <Student> getStudents();

    List <Student> getStudentByCity(String city);

    void addNewStudent(Student student);

    void updateStudent(Long studentId, String name, String city, String email);
}
