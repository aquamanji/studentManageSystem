package com.learn.system.service.serviceImpl;

import com.learn.system.mapper.StudentMapper;
import com.learn.system.mapper.TeacherMapper;
import com.learn.system.pojo.Course;
import com.learn.system.pojo.Score;
import com.learn.system.pojo.Student;
import com.learn.system.service.StudentService;
import com.learn.system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.transform.Source;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;


    @Override
    public List<Course> queryAllCourse(String teano) {
        return teacherMapper.queryAllCourse(teano);
    }

    @Override
    public List<Course> querySomeCourse(List<Course> CourseList, int pageNum, int offset) {
        List<Course> list = new ArrayList<Course>();    //pageNum是从0开始的
        int num = (pageNum-1)*offset;   //需要略过的课程数
        int cnt = 0;        //记录添加的数量
        for(Course li : CourseList){
            if(num!=0){
                num--;
                continue;
            }
            list.add(li);
            cnt++;
            if(cnt == offset){
                return list;
            }
        }
        return list;    //这里是数量不足offset的时候的返回值
    }

    @Override
    public List<Score> queryAllScore(String teano, String courseNo) {
        return teacherMapper.queryAllScore(teano, courseNo);
    }



    @Override
    public List<Score> querySomeScore(List<Score> ScoreList, int pageNum, int offset) {
        List<Score> list = new ArrayList<Score>();    //pageNum是从0开始的
        int num = (pageNum-1)*offset;   //需要略过的课程数
        int cnt = 0;        //记录添加的数量
        for(Score li : ScoreList){
            if(num!=0){
                num--;
                continue;
            }
            list.add(li);
            cnt++;
            if(cnt == offset){
                return list;
            }
        }
        return list;    //这里是数量不足offset的时候的返回值
    }

    @Override
    public void updateScore(String stuNo, String courseNo, Integer score) {
        teacherMapper.updateScore(stuNo,courseNo,score);
    }

    @Override
    public Score getOneStudentScore(String stuNo, String courseNo) {
        return teacherMapper.getOneStudentScore(stuNo, courseNo);
    }


}
