package com.edu.studentsystem_20211128.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.studentsystem_20211128.domain.LeaveMessage;
import com.edu.studentsystem_20211128.service.LeaveMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LeaveMessageController {
    @Autowired
    private LeaveMessageService leaveMessageService;


    //查所有
    @GetMapping("/leaveMessage")
    public String leaveList(Model model) {

        int count = leaveMessageService.count();
        Page<LeaveMessage> page = new Page<>(1, count);
        //调用page加载所有数据
        Page<LeaveMessage> leavePage = leaveMessageService.page(page, null);
        model.addAttribute("leaveMessage", leavePage);
        return "leaveMessage/leaveMessageList";

    }


    //创建选课条目
    //跳到创建页面
    @GetMapping("/leaveMessagecreate")
    public String leaveCreate() {
        return "leaveMessage/leaveMessageCreate";
    }

    //创建新学生
    @PostMapping("/leaveMessageCreateOne")
    public String studentCreateOne(LeaveMessage leaveMessage){
        leaveMessageService.save(leaveMessage);
        return "redirect:/leaveMessage";
    }


    //删除
    @GetMapping("leaveMessagedelect/{id}")
    public String leaveDelect(@PathVariable("id") Integer id, Model model) {

        leaveMessageService.removeById(id);
        return  "redirect:/leaveMessage";
    }

    //修改
    @GetMapping("/leaveMessageedit/{id}")
    public String leavetEdit(LeaveMessage leaveMessage,
                             @PathVariable("id") Integer id,
                             Model model) {
        LeaveMessage byId = leaveMessageService.getById(id);
        model.addAttribute("s",byId);
        return "leaveMessage/leaveMessageEdit";
    }


    //
    @PostMapping("/leaveMessageeditone")
    public String updateOneUser(LeaveMessage leaveMessage){
        leaveMessageService.updateById(leaveMessage);
        return "redirect:/leaveMessage";

    }

}
