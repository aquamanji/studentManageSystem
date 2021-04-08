package com.learn.system;

import com.learn.system.pojo.Student;
import com.learn.system.service.StudentService;
import com.learn.system.service.TeacherService;
import com.learn.system.service.serviceImpl.StudentServiceImpl;
import com.learn.system.service.serviceImpl.TeacherServiceImpl;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootTest
class SystemApplicationTests {

    @Test
    void contextLoads() {
        String Nowtime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        Date time= new java.sql.Date(new java.util.Date().getTime());
        System.out.println(time);
    }



}
