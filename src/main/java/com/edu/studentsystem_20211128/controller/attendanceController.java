package com.edu.studentsystem_20211128.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.studentsystem_20211128.domain.Attendance;
import com.edu.studentsystem_20211128.domain.LeaveMessage;
import com.edu.studentsystem_20211128.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class attendanceController {

    @Autowired
    private AttendanceService attendanceService;

    //查所有
    @GetMapping("/attendance")
    public String attendanceList(Model model) {

        int count = attendanceService.count();
        Page<Attendance> page = new Page<>(1, count);
        //调用page加载所有数据
        Page<Attendance> attendancePage = attendanceService.page(page, null);
        model.addAttribute("attendance", attendancePage);
        return "attendance/attendanceList";

    }




}
