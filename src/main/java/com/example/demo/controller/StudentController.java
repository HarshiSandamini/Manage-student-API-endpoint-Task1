package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student-details")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/student-List")
    public ResponseEntity<List<Student>> studentDetails(@RequestParam String city){
        List<Student> studentList = studentService.getStudentByCity(city);

        if(studentList.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @PostMapping
    public void registerNewStudent(@Valid @RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@Valid @PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String city,
                              @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,city,email);

    }
}
