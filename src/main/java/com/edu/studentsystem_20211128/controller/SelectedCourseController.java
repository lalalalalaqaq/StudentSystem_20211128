package com.edu.studentsystem_20211128.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.edu.studentsystem_20211128.domain.SelectedCourse;
import com.edu.studentsystem_20211128.domain.Student;
import com.edu.studentsystem_20211128.service.SelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SelectedCourseController {

    @Autowired
    private SelectedCourseService selectedCourseService;


    //查所有
    @GetMapping("/selectedCourse")
    public String selectedCourseList(Model model) {

        int count = selectedCourseService.count();
        Page<SelectedCourse> page = new Page<>(1, count);
        //调用page加载所有数据
        Page<SelectedCourse> selectedCoursePage = selectedCourseService.page(page, null);
        model.addAttribute("selectedCourse", selectedCoursePage);
        return "selectedCourse/selectedCourseList";

    }


//    //创建选课条目
//    //跳到创建学生页面
//    @GetMapping("/selectedCoursecreate")
//    public String selectedCourseCreate() {
//        return "selectedCourse/selectedCourseCreate";
//    }
//
//    //创建新学生
//    @PostMapping("/selectedCourseCreateOne")
//    public String studentCreateOne(SelectedCourse selectedCourse){
//        selectedCourseService.save(selectedCourse);
//        return "redirect:/selectedCourse";
//    }
//

    //删除
    @GetMapping("selectedCoursedelect/{id}")
    public String selectedCourseDelect(@PathVariable("id") Integer id, Model model) {

        selectedCourseService.removeById(id);
        return  "redirect:/selectedCourse";
    }

    //修改
    @GetMapping("/selectedCourseedit/{id}")
    public String selectedCoursetEdit(SelectedCourse selectedCourse,
                              @PathVariable("id") Integer id,
                              Model model) {
        SelectedCourse byId = selectedCourseService.getById(id);
        model.addAttribute("s",byId);
        return "selectedCourse/selectedCourseEdit";
    }


    //
    @PostMapping("/selectedCourseeditone")
    public String updateOneUser(SelectedCourse selectedCourse){
        selectedCourseService.updateById(selectedCourse);
        return "redirect:/selectedCourse";

    }


}
