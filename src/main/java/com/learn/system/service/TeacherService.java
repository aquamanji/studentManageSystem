package com.learn.system.service;

import com.learn.system.pojo.Course;
import com.learn.system.pojo.Score;
import com.learn.system.pojo.Student;
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

}
