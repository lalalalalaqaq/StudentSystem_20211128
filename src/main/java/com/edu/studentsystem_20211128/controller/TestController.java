package com.edu.studentsystem_20211128.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/common")
    public String commonPage(){
        return "common";
    }


    @GetMapping("/datalist")
    public String datalist(){
        return "studentList";
    }


}
