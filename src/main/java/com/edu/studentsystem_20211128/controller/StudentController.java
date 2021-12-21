package com.edu.studentsystem_20211128.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.studentsystem_20211128.domain.Student;
import com.edu.studentsystem_20211128.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {


    @Autowired
    private StudentService studentService;


    /**
     * D
     * @param model
     * @return
     */
    //加载学生数据
    @GetMapping("/student")
    public String studentList(Model model){

        int count = studentService.count();
        Page<Student> page = new Page<>(1,count);
        //调用page加载所有数据
        Page<Student> studentPage = studentService.page(page,null);
        model.addAttribute("student",studentPage);
        return  "student/studentList";


    }




    /**
     * C
     * @return
     */
    //跳到创建学生页面
    @GetMapping("/studentcreate")
    public String studentCreate() {
        return "student/studentCreate";
    }

    //创建新学生
    @PostMapping("/studentCreateOne")
    public String studentCreateOne(Student student){
        studentService.save(student);
        return "redirect:/student";
    }


    /**
     * R
     * @param id
     * @param model
     * @return
     */
    //删除学生
    @GetMapping("studentdelect/{id}")
    public String studentDelect(@PathVariable("id") Integer id, Model model) {

        studentService.removeById(id);
        return  "redirect:/student";
    }




    /**
     * U
     * @param student
     * @param id
     * @param model
     * @return
     */
    //修改学生数据
    @GetMapping("/studentedit/{id}")
    public String studentEdit(Student student,
                              @PathVariable("id") Integer id,
                              Model model) {
        Student byId = studentService.getById(id);
        model.addAttribute("s",byId);
        return "student/studentEdit";
    }


    //
    @PostMapping("/studenteditone")
    public String updateOneUser(Student student){
        System.out.println(student.toString());
        studentService.updateById(student);
        return "redirect:/student";

    }





}
