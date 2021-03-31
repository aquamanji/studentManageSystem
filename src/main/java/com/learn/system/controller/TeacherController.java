package com.learn.system.controller;

import com.learn.system.mapper.TeacherMapper;
import com.learn.system.pojo.Course;
import com.learn.system.pojo.Score;
import com.learn.system.pojo.Student;
import com.learn.system.service.TeacherService;
import com.learn.system.service.serviceImpl.StudentServiceImpl;
import com.learn.system.service.serviceImpl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherServiceImpl teacherService;



    //查询老師課程表
    @RequestMapping(value="/teachcourse/{pageNum}", method = RequestMethod.GET)
    public ModelAndView teachcourse(@PathVariable("pageNum")int pageNum,
                                  ModelAndView mv, HttpSession session){
        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        String teano = (String)session.getAttribute("stuNo");
        int offset = 5;     //每页显示的数量
        int total = teacherService.queryAllCourse(teano).size(); //学生信息总数
        int totalPage = total/offset;
        if(total%offset !=0){
            totalPage++;
        }
        if(totalPage == 0){
            totalPage=1;
        }
        mv.addObject("totalPage", totalPage);
        mv.addObject("pageNum", pageNum);
        List<Course> CourseList = new ArrayList<Course>();
        CourseList = teacherService.querySomeCourse(teacherService.queryAllCourse(teano),
                pageNum, offset);
        mv.addObject("CourseList", CourseList);
        mv.setViewName("courseList");
        return mv;
    }









}
