package com.edu.studentsystem_20211128.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.studentsystem_20211128.domain.Course;
import com.edu.studentsystem_20211128.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public String courseList(Model model) {

        int count = courseService.count();
        Page<Course> page = new Page<>(1, count);
        //调用page加载所有数据
        Page<Course> coursePage = courseService.page(page, null);
        model.addAttribute("course", coursePage);
        return "course/courseList";

    }


    @GetMapping("/coursecreate")
    public String courseCreate(){
        return "course/courseCreate";
    }

    //创建新学生
    @PostMapping("/courseCreateOne")
    public String courseCreateOne(Course course){
        courseService.save(course);
        return "redirect:/course";
    }

    //删除学生
    @GetMapping("coursedelect/{id}")
    public String courseDelect(@PathVariable("id") Integer id, Model model) {

        courseService.removeById(id);
        return  "redirect:/course";
    }

    @GetMapping("/courseedit/{id}")
    public String studentEdit(Course course,
                              @PathVariable("id") Integer id,
                              Model model) {
        Course byId = courseService.getById(id);
        model.addAttribute("s",byId);
        return "course/courseEdit";
    }


    //
    @PostMapping("/courseeditone")
    public String updateOneUser(Course course){
        courseService.updateById(course);
        return "redirect:/course";

    }


}
