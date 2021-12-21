package com.edu.studentsystem_20211128.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edu.studentsystem_20211128.domain.LeaveMessage;
import com.edu.studentsystem_20211128.mapper.LeaveMessageMapper;
import com.edu.studentsystem_20211128.service.LeaveMessageService;
import org.springframework.stereotype.Service;

@Service
public class LeaveMessageServiceImpl extends ServiceImpl<LeaveMessageMapper, LeaveMessage> implements LeaveMessageService {
}
