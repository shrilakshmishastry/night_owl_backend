package com.nightowl.apis.config;

import com.nightowl.apis.models.entities.Student;
import com.nightowl.apis.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
      return args -> {
         Student shri =  new Student(

                  "shri",
                  "shri@gmail.com",
                  LocalDate.of(1999, Month.OCTOBER,29)

          );
          Student lakshmi =  new Student(

                  "shri",
                  "shri@gmail.com",
                  LocalDate.of(1999, Month.OCTOBER,29)

          );
          ArrayList<Student> arr = new ArrayList<Student>();
          arr.add(shri);
          arr.add(lakshmi);

          studentRepository.saveAll(
                  arr
          );

      };
    }
}
