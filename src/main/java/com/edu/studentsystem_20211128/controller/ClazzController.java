package com.edu.studentsystem_20211128.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.studentsystem_20211128.domain.Clazz;
import com.edu.studentsystem_20211128.domain.Student;
import com.edu.studentsystem_20211128.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * D
     * @param model
     * @return
     */
    //加载班级数据
    @GetMapping("/clazz")
    public String clazzList(Model model) {

        int count = clazzService.count();
        Page<Clazz> page = new Page<>(1, count);
        //调用page加载所有数据
        Page<Clazz> clazzPage = clazzService.page(page, null);
        model.addAttribute("clazz", clazzPage);
        return "clazz/clazzList";


    }

    /**
     *
     * @return
     */

    @GetMapping("/clazzcreate")
    public String clazzCreate(){
        return "clazz/clazzCreate";
    }

    //创建新学生
    @PostMapping("/clazzCreateOne")
    public String clazzCreateOne(Clazz clazz){
        clazzService.save(clazz);
        return "redirect:/clazz";
    }


    /**
     * R
     * @param id
     * @param model
     * @return
     */
    //删除学生
    @GetMapping("clazzdelect/{id}")
    public String clazzDelect(@PathVariable("id") Integer id, Model model) {

        clazzService.removeById(id);
        return  "redirect:/clazz";
    }

    /**
     * U
     * @param clazz
     * @param id
     * @param model
     * @return
     */
    //修改学生数据
    @GetMapping("/clazzedit/{id}")
    public String studentEdit(Clazz clazz,
                              @PathVariable("id") Integer id,
                              Model model) {
        Clazz byId = clazzService.getById(id);
        model.addAttribute("s",byId);
        return "clazz/clazzEdit";
    }


    //
    @PostMapping("/clazzeditone")
    public String updateOneUser(Clazz clazz){
        clazzService.updateById(clazz);
        return "redirect:/clazz";

    }


}
