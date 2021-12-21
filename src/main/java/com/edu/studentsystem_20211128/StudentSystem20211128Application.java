package com.edu.studentsystem_20211128;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.edu.studentsystem_20211128.mapper")
@SpringBootApplication
public class StudentSystem20211128Application {

    public static void main(String[] args) {
        SpringApplication.run(StudentSystem20211128Application.class, args);
    }

}
