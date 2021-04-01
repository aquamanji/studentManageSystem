package com.learn.system.mapper;

import com.learn.system.pojo.Account;
import com.learn.system.pojo.Course;
import com.learn.system.pojo.Score;
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
    void updateScore(@Param("stuNo") String stuNo,@Param("courseNo") String courseNo,@Param("score") Integer score);

    //返回单个学生的单科成绩
    Score getOneStudentScore(@Param("stuNo") String stuNo,@Param("courseNo") String courseNo);


}
