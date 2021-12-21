package com.edu.studentsystem_20211128.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.studentsystem_20211128.domain.Admin;
import com.edu.studentsystem_20211128.mapper.AdminMapper;
import com.edu.studentsystem_20211128.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
