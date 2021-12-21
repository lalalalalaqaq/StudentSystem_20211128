package com.edu.studentsystem_20211128.service.impl;



import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.studentsystem_20211128.domain.Attendance;
import com.edu.studentsystem_20211128.mapper.AttendanceMapper;
import com.edu.studentsystem_20211128.service.AttendanceService;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {

}
