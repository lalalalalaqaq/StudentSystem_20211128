package com.edu.studentsystem_20211128;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.studentsystem_20211128.domain.Clazz;
import com.edu.studentsystem_20211128.domain.Student;
import com.edu.studentsystem_20211128.domain.Teacher;
import com.edu.studentsystem_20211128.mapper.StudentMapper;
import com.edu.studentsystem_20211128.mapper.TeacherMapper;
import com.edu.studentsystem_20211128.service.ClazzService;
import com.edu.studentsystem_20211128.service.StudentService;
import com.edu.studentsystem_20211128.service.TeacherService;
import org.apache.ibatis.javassist.bytecode.FieldInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@SpringBootTest
class StudentSystem20211128ApplicationTests {



    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    ClazzService clazzService;

    @Test
    public void testMybatisPlus() {
        System.out.println(("----- selectAll method test ------"));
        Student byId = studentMapper.selectById(13);
        System.out.println(byId.toString());
    }



    @Test
    public void testMybatisPlusPage1(){
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        IPage<Student> productIPage=new Page<>(0, 3);
        productIPage = studentMapper.selectPage(productIPage,wrapper);
        System.out.println(productIPage.getRecords().toString());
    }

    @Test
    public void testMybatisPlusPage2(){
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        IPage<Teacher> productIPage=new Page<>(0, 3);
        productIPage = teacherMapper.selectPage(productIPage,wrapper);
        System.out.println(productIPage.getRecords().toString());
    }


    @Test
    public void testMybatisWarpper(){

        QueryWrapper<Clazz> clazzQueryWrapper = new QueryWrapper<>();
        //指定查询字段
        clazzQueryWrapper.select("id", "info");
        List<Clazz> list = clazzService.list(clazzQueryWrapper);

        System.out.println(list.toString());




    }




}
