package com.learn.system.pojo;

public class Scorenew {
    String stuNo;
    String courseNo;
    String term;
    Integer score;

    public Scorenew(String stuNo, String courseNo, String term, Integer score) {
        this.stuNo = stuNo;
        this.courseNo = courseNo;
        this.term = term;
        this.score = score;
    }

    public Scorenew() {
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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Scorenew{" +
                "stuNo='" + stuNo + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", term='" + term + '\'' +
                ", score=" + score +
                '}';
    }
}
