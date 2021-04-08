package com.learn.system.controller;

import com.learn.system.mapper.TeacherMapper;
import com.learn.system.pojo.*;
import com.learn.system.service.TeacherService;
import com.learn.system.service.serviceImpl.StudentServiceImpl;
import com.learn.system.service.serviceImpl.TeacherServiceImpl;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
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


    @RequestMapping(value="/teachGetSource/{courseNo}/{pageNum}", method = RequestMethod.GET)
    public ModelAndView teachGetSource(@PathVariable("pageNum")int pageNum,
                                    @PathVariable("courseNo") String courseNo,
                                    ModelAndView mv, HttpSession session){
        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        session.setAttribute("courseNo",(String)courseNo);
        mv.addObject("courseNo",(String)session.getAttribute("courseNo"));
        String teano = (String)session.getAttribute("stuNo");
        int offset = 5;     //每页显示的数
        int total = teacherService.queryAllScore(teano,courseNo).size(); //学生信息总数
        int totalPage = total/offset;
        if(total%offset !=0){
            totalPage++;
        }
        if(totalPage == 0){
            totalPage=1;
        }
        mv.addObject("totalPage", totalPage);
        mv.addObject("pageNum", pageNum);
        List<Score> ScoreList = new ArrayList<Score>();
        ScoreList = teacherService.querySomeScore(teacherService.queryAllScore(teano,courseNo),
                pageNum, offset);
        mv.addObject("ScoreList", ScoreList);
        mv.setViewName("scoreList");
        return mv;
    }

    //查询单个学生
    @RequestMapping(value="/getOneStudentScore/{Stuno}/{Course}", method = RequestMethod.GET)
    public ModelAndView getOneStudentScore(@PathVariable("Stuno")String stuNo,
                                    @PathVariable("Course")String courseNo,
                                    ModelAndView mv, HttpSession session){
        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        Score oneStudentScore = teacherService.getOneStudentScore(stuNo, courseNo);
        mv.addObject("Student",oneStudentScore);
        mv.setViewName("changeScore");
        return mv;
    }


    //修改成绩
    @RequestMapping(value = "/updateScore", method = RequestMethod.POST)
    public ModelAndView updateScore(@RequestParam("stuStuNo")String stuStuNo,
                                    @RequestParam("stuStuCourseNo")String stuStuCourseNo,
                                    @RequestParam("stuChangeScore")Integer stuChangeScore,
                                    ModelAndView mv, HttpSession session){
        //先检查是否存在相同的班级号
        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        stuStuNo = (String)stuStuNo;
        stuStuCourseNo = (String)stuStuCourseNo;
        stuChangeScore = (Integer) stuChangeScore;
        teacherService.updateScore(stuStuNo,stuStuCourseNo,stuChangeScore);
        Score oneStudentScore = teacherService.getOneStudentScore(stuStuNo, stuStuCourseNo);
        mv.addObject("Student",oneStudentScore);
        mv.addObject("success", 1);
        mv.setViewName("changeScore");
        return mv;
    }


    //返回term信息
    @RequestMapping(value="/toInsertCourseInfo", method = RequestMethod.GET)
    public ModelAndView toInsertCourseInfo(
                                           ModelAndView mv, HttpSession session){
        teacherService.getTermList();
        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        mv.addObject("TermList",teacherService.getTermList());
        mv.setViewName("insertCourseInfo");
        return mv;
    }


    @RequestMapping(value="/InsertCourseInfo", method = RequestMethod.POST)
    public ModelAndView InsertCourseInfo(
            @RequestParam("courseNo")String courseNo,
            @RequestParam("courseName")String courseName,
            @RequestParam("credit")String credit,
            @RequestParam("courseHour")String courseHour,
            @RequestParam("volume")String volume,
            @RequestParam("term")String term,
            ModelAndView mv, HttpSession session){
        String teachno =  (String)session.getAttribute("stuNo");
        System.out.println(credit);
        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        mv.addObject("TermList",teacherService.getTermList());
        if(teachno == "" || courseHour == ""||courseNo ==""||courseName == ""|| term == "" || credit == "" ||volume ==""){
            mv.addObject("success", 0);
            mv.setViewName("insertCourseInfo");
            return mv;
        }
        try {

            int a = Integer.parseInt(courseHour);
            int b = Integer.parseInt(credit);
            int c = Integer.parseInt(volume);
            Course course = new Course();
            course.setTeachno(teachno);
            course.setCourseNo(courseNo);
            course.setCourseHour(a);
            course.setCourseName(courseName);
            course.setTerm(term);
            course.setCredit(b);
            course.setVolume(c);
            course.setIschoosing(0);
            teacherService.InsertCourseInfo(course);
            mv.addObject("success", 1);
            mv.setViewName("insertCourseInfo");
            return mv;

        } catch (NumberFormatException e) {
            mv.addObject("success", 0);
            mv.setViewName("insertCourseInfo");
            return mv;

        }

    }


    //去公告插入页面
    @RequestMapping(value="/toInsertNoticeInfo", method = RequestMethod.GET)
    public ModelAndView toInsertNoticeInfo(
            ModelAndView mv, HttpSession session){

        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        mv.setViewName("insertNoticeInfo");
        return mv;
    }
    //公告插入
    @RequestMapping(value="/InsertNoticeInfo", method = RequestMethod.POST)
    public ModelAndView InsertNoticeInfo(
            @RequestParam("content")String content,
            ModelAndView mv, HttpSession session){
        String teachno =  (String)session.getAttribute("stuNo");
        java.sql.Date time= new java.sql.Date(new java.util.Date().getTime());
        Notice notice = new Notice();
        notice.setContent(content);
        notice.setTeano(teachno);
        notice.setPutdate(time);
        teacherService.InsertNoticeInfo(notice);
        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        mv.addObject("success", 1);
        mv.setViewName("insertNoticeInfo");
        return mv;

    }

    //查询老師公告
    @RequestMapping(value="/getTeacherNotice/{pageNum}", method = RequestMethod.GET)
    public ModelAndView getTeacherNotice(@PathVariable("pageNum")int pageNum,
                                    ModelAndView mv, HttpSession session){
        mv.addObject("userType", session.getAttribute("userType"));
        mv.addObject("userName", session.getAttribute("stuNo"));
        String teano = (String)session.getAttribute("stuNo");
        int offset = 5;     //每页显示的数量
        int total = teacherService.queryAllNoticeByTeahcer(teano).size(); //学生信息总数
        int totalPage = total/offset;
        if(total%offset !=0){
            totalPage++;
        }
        if(totalPage == 0){
            totalPage=1;
        }
        mv.addObject("totalPage", totalPage);
        mv.addObject("pageNum", pageNum);
        List<Notice> NoticeList = new ArrayList<Notice>();
        NoticeList = teacherService.querysomeNoticeByTeahcer(teacherService.queryAllNoticeByTeahcer(teano),
                pageNum, offset);
        mv.addObject("NoticeList", NoticeList);
        mv.setViewName("teacherNoticeList");
        return mv;
    }



}
