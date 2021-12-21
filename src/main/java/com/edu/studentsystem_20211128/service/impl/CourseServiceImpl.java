package com.edu.studentsystem_20211128.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.studentsystem_20211128.domain.Course;
import com.edu.studentsystem_20211128.mapper.CourseMapper;
import com.edu.studentsystem_20211128.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl  extends ServiceImpl<CourseMapper, Course> implements CourseService {


}
