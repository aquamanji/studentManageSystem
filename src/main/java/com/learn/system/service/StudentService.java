package com.learn.system.service;

import com.learn.system.pojo.Course;
import com.learn.system.pojo.Score;
import com.learn.system.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {

    //通过学号查询某个学生信息
    Student selectStu(String stuNo);

    //查询所有学生信息
    List<Student> selectAllStu();

    //计算某个学生的平均分
    double calStuAverage(String stuNo);

    //计算某个学生已修学分
    Integer calStuCredit(String stuNo);

    //查找学生有成绩的所有课程
    List<Course> queryAllCourse(String stuNo);

    //分页查找学生课程
    List<Course> querySomeCourse(List<Course> courseList, int pageNum, int offset);

    //查找学生的所有成绩
    List<Score> queryAllScore(String stuNo);

    //分页查找学生成绩
    List<Score> querySomeScore(List<Score> scoreList, int pageNum, int offset);

    //返回可查询课程
    List<Course> queryAllIsOpen();

    //返回当前学生是否选择了这门课程
    Score getStudentscore(Score score);

    //添加课程
    void insertStudentScore(@Param("stuNo") String stuNo,@Param("courseNo") String courseNo,@Param("term") String term);

    //修改课程余量
    void updateCourseVolumeAdd(@Param("courseNo") String courseNo);

    //返回课程余量
    int getCourseVolume(@Param("courseNo")String courseNo);

    //增加课程余量
    void updateCourseVolumeRealAdd(@Param("courseNo") String courseNo);

    //取消选课
    void deleteStudentScore(@Param("stuNo") String stuNo,@Param("courseNo") String courseNo,@Param("term") String term);
}
