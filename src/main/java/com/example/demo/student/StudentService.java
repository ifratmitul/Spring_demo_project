package com.example.demo.student;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Component
public class StudentService {

    public List<Student> getStudentList() {
        return List.of(
                new Student(1L,
                        "Ifrat",
                        25, LocalDate.of(1995, Month.OCTOBER, 25),
                        "ifrat@jotno.net"));
    }

}
