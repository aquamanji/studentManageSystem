package com.learn.system.pojo;

//这个是用于连接查询的pojo
public class Score {
    String stuNo;
    String courseNo;
    String term;
    int score;
    String courseName;      //这是连接课程表的课程名
    String teaname;

    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public Score(String stuNo, String courseNo, String term, int score, String courseName, String teaname) {
        this.stuNo = stuNo;
        this.courseNo = courseNo;
        this.term = term;
        this.score = score;
        this.courseName = courseName;
        this.teaname = teaname;
    }

    public Score() {
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Score{" +
                "stuNo='" + stuNo + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", term='" + term + '\'' +
                ", score=" + score +
                ", courseName='" + courseName + '\'' +
                ", teaname='" + teaname + '\'' +
                '}';
    }
}
