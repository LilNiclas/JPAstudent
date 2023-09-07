package com.example.jpa.controller;

import com.example.jpa.model.Student;
import com.example.jpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    //Get students
    @GetMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

    //Lav ændring så den kun laver ny student, hvis id'et ikke er taget
    //Create Student
    @PostMapping ("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    //Edit Student
    //få indsat id i student før student gemmes
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> putMapping(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
            //return ResponseEntity.ok(student)
        } else {
            //return ResponseEntity.notFound().build();
            return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    //Delete Student
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }
}