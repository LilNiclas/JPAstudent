package com.example.jpa.config;

import com.example.jpa.model.Student;
import com.example.jpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student s1 = new Student();
        s1.setName("Jarl");
        s1.setBornDate(LocalDate.of(2020, 05, 17));
        s1.setBornTime(LocalTime.of(15, 04, 58));
        studentRepository.save(s1);

        s1.setName("Jens");
        studentRepository.save(s1);

        s1.setId(2);
        s1.setName("Krisser");
        studentRepository.save(s1);
    }

}
