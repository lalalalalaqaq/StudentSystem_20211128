package com.edu.studentsystem_20211128.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/timeline")
    public String timeline(){
        return "timeline/timeline";
    }


}
