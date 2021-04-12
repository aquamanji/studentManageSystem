package com.learn.system;

import com.learn.system.pojo.Score;
import com.learn.system.pojo.Student;
import com.learn.system.service.StudentService;
import com.learn.system.service.TeacherService;
import com.learn.system.service.serviceImpl.StudentServiceImpl;
import com.learn.system.service.serviceImpl.TeacherServiceImpl;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootTest
class SystemApplicationTests {
    @Test
    void contextLoads() {

    }



}
