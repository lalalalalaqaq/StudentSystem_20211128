package com.edu.studentsystem_20211128.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.studentsystem_20211128.domain.Student;
import com.edu.studentsystem_20211128.mapper.StudentMapper;
import com.edu.studentsystem_20211128.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


}
