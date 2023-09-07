package com.example.jpa;

import com.example.jpa.model.Student;
import com.example.jpa.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class JpaApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student std = new Student();
        std.setName("Lars");
        studentRepository.save(std);
    }


    @Test
    void testOneStudent() {
        List<Student> list = studentRepository.findAll();
        assertEquals(1, list.size());
    }

}
