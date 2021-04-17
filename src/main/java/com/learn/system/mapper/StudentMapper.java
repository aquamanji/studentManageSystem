package com.learn.system.mapper;

import com.learn.system.pojo.Course;
import com.learn.system.pojo.Score;
import com.learn.system.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface StudentMapper {


    //通过学号查询某个学生信息
    Student selectStu(String stuNo);

    //查询所有学生信息
    List<Student> selectAllStu();

    //返回一个学生所有课程成绩的总和
    Integer calStuSum(String stuNo);

    //返回一个学生有成绩的课程数
    Integer getScoreNum(String stuNo);

    //计算某个学生已修学分
    Integer calStuCredit(String stuNo);

    //查找学生有成绩的所有课程
    List<Course> queryAllCourse(String stuNo);

    //查找学生所有成绩
    List<Score> queryAllScore(String stuNo);

    //选课列表
    List<Course> queryAllIsOpen();


    //获取当前学生是否已选本门课程
    Score getStudentscore(@Param("stuNo") String stuNo,@Param("courseNo") String courseNo);

    //添加课程
    void insertStudentScore(@Param("stuNo") String stuNo,@Param("courseNo") String courseNo,@Param("term") String term);

    //取消选课
    void deleteStudentScore(@Param("stuNo") String stuNo,@Param("courseNo") String courseNo,@Param("term") String term);

    //减少课程余量
    void updateCourseVolumeAdd(@Param("courseNo") String courseNo);

    //增加课程余量
    void updateCourseVolumeRealAdd(@Param("courseNo") String courseNo);

    //返回课程余量
    int getCourseVolume(@Param("courseNo")String courseNo);








}
