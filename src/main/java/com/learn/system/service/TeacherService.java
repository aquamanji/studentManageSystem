package com.learn.system.service;

import com.learn.system.pojo.Course;
import com.learn.system.pojo.Score;
import com.learn.system.pojo.Student;

import java.util.List;

public interface TeacherService {

    //查找老师所有课程
    List<Course> queryAllCourse(String teano);


    //寻找部分Course
    List<Course> querySomeCourse(List<Course> CourseList, int pageNum, int offset);

}
