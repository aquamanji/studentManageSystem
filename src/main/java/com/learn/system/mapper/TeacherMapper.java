package com.learn.system.mapper;

import com.learn.system.pojo.Account;
import com.learn.system.pojo.Course;
import com.learn.system.pojo.Score;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TeacherMapper {

    //查找老师所有课程
    List<Course> queryAllCourse(String teano);


}
