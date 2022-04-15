package com.example.demo.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student a = new Student(
                    "Ifrat", LocalDate.of(1995, Month.OCTOBER, 25),
                    "ifrat@jotno.net");

            Student b = new Student(
                    "kuddus",
                     LocalDate.of(1995, Month.OCTOBER, 25),
                    "ik@jotno.net");

            repository.saveAll(List.of(a,b));
        };
    }

}
