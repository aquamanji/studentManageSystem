package com.learn.system.service;

import com.learn.system.pojo.*;
import org.apache.ibatis.annotations.Param;

import javax.xml.transform.Source;
import java.util.List;

public interface TeacherService {

    //查找老师所有课程
    List<Course> queryAllCourse(String teano);


    //寻找部分Course
    List<Course> querySomeCourse(List<Course> CourseList, int pageNum, int offset);

    //寻找担任课程名下的学生：
    List<Score> queryAllScore(String teano,String courseNo);


    //寻找部分Source
     List<Score> querySomeScore(List<Score> ScoreList, int pageNum, int offset);


     //更新成绩
    void updateScore(String stuNo,String courseNo,Integer score);

    //获取单个学生信息
    Score getOneStudentScore(String stuNo, String courseNo);

    //获取学期信息
    List<Term> getTermList();

    //插入课程表
    void InsertCourseInfo(Course course);

    //插入公告表
    void InsertNoticeInfo(Notice notice);

    //查找老师当前发布的公告
    List<Notice> queryAllNoticeByTeahcer(String teano);

    //查找老师当前发布的部分公告
    List<Notice> querysomeNoticeByTeahcer(List<Notice> NoticeList, int pageNum, int offset);


}
