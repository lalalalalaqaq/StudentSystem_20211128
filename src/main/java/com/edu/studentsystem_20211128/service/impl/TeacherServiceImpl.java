package com.edu.studentsystem_20211128.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.studentsystem_20211128.domain.Student;
import com.edu.studentsystem_20211128.domain.Teacher;
import com.edu.studentsystem_20211128.mapper.StudentMapper;
import com.edu.studentsystem_20211128.mapper.TeacherMapper;
import com.edu.studentsystem_20211128.service.StudentService;
import com.edu.studentsystem_20211128.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

}
