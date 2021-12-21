package com.edu.studentsystem_20211128.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.studentsystem_20211128.domain.Clazz;
import com.edu.studentsystem_20211128.domain.Student;
import com.edu.studentsystem_20211128.domain.Teacher;
import com.edu.studentsystem_20211128.service.ClazzService;
import com.edu.studentsystem_20211128.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {


    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ClazzService clazzService;


    @GetMapping("/teacher")
    public String teacherList(Model model){

        int count = teacherService.count();
        Page<Teacher> page = new Page<>(1,count);

        //调用page加载所有数据
        Page<Teacher> teacherPage = teacherService.page(page,null);
        model.addAttribute("teacher",teacherPage);
        return  "teacher/teacherList";


    }


    //跳到创建教师页面
    @GetMapping("/teachercreate")
    public String teacherCreate() {
        return "teacher/teacherCreate";
    }


    //创建新学生
    @PostMapping("/teacherCreateOne")
    public String teacherCreateOne(Teacher teacher){
        teacherService.save(teacher);
        return "redirect:/teacher";
    }


    /**
     * R
     * @param id
     * @param model
     * @return
     */
    //删除学生
    @GetMapping("teacherdelect/{id}")
    public String teacherDelect(@PathVariable("id") Integer id, Model model) {

        teacherService.removeById(id);
        return  "redirect:/teacher";
    }




    /**
     * U
     * @param teacher
     * @param id
     * @param model
     * @return
     */
    //修改学生数据
    @GetMapping("/teacheredit/{id}")
    public String teacherEdit(Teacher teacher,
                              @PathVariable("id") Integer id,
                              Model model) {
        Teacher byId = teacherService.getById(id);
        model.addAttribute("s",byId);

//        QueryWrapper<Clazz> clazzQueryWrapper = new QueryWrapper<>();
//        //指定查询字段
//        clazzQueryWrapper.select("id", "info");
//        List<Clazz> clazzList = clazzService.list(clazzQueryWrapper);
//        model.addAttribute("clazzList",clazzList);

        return "teacher/teacherEdit";
    }


    //
    @PostMapping("/teachereditone")
    public String updateOneUser(Teacher teacher){
        teacherService.updateById(teacher);
        return "redirect:/teacher";

    }


}
