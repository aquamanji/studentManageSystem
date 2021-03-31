package com.learn.system.pojo;

public class Course {

    String courseNo;
    String courseName;
    int credit;
    int courseHour;
    String priorCourse;
    int ischoosing;
    int volume;
    String teachno;

    public Course(String courseNo, String courseName, int credit, int courseHour, String priorCourse, int ischoosing, int volume, String teachno) {
        this.courseNo = courseNo;
        this.courseName = courseName;
        this.credit = credit;
        this.courseHour = courseHour;
        this.priorCourse = priorCourse;
        this.ischoosing = ischoosing;
        this.volume = volume;
        this.teachno = teachno;
    }

    public String getTeachno() {
        return teachno;
    }

    public void setTeachno(String teachno) {
        this.teachno = teachno;
    }

    public int getIschoosing() {
        return ischoosing;
    }

    public void setIschoosing(int ischoosing) {
        this.ischoosing = ischoosing;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Course() {
    }


    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(int courseHour) {
        this.courseHour = courseHour;
    }

    public String getPriorCourse() {
        return priorCourse;
    }

    public void setPriorCourse(String priorCourse) {
        this.priorCourse = priorCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", courseHour=" + courseHour +
                ", priorCourse='" + priorCourse + '\'' +
                ", ischoosing=" + ischoosing +
                ", volume=" + volume +
                '}';
    }
}
