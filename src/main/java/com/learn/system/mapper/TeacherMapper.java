package com.learn.system.mapper;

import com.learn.system.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import java.util.List;

@Mapper
@Component
public interface TeacherMapper {

    //查找老师所有课程
    List<Course> queryAllCourse(String teano);

    //查找老师当前课程的学生
    List<Score> queryAllScore(@Param("teano") String teano,@Param("courseNo")String courseNo);

    //更新成绩
    void updateScore(Score score);

    //返回单个学生的单科成绩
    Score getOneStudentScore(@Param("stuNo") String stuNo,@Param("courseNo") String courseNo);


    //返回日期
    List<Term> getTermList();

    //插入课程表
    void InsertCourseInfo(Course course);

    //插入公告
    void InsertNoticeInfo(Notice notice);

    //查找老师当前发布的公告
    List<Notice> queryAllNoticeByTeahcer(@Param("teano") String teano);
}
