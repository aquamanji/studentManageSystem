package com.learn.system.pojo;

import java.util.Date;

public class Notice {
    int id;
    String teano;
    String content;
    Date putdate;

    public Notice() {
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", teano='" + teano + '\'' +
                ", content='" + content + '\'' +
                ", putdate=" + putdate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeano() {
        return teano;
    }

    public void setTeano(String teano) {
        this.teano = teano;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPutdate() {
        return putdate;
    }

    public void setPutdate(Date putdate) {
        this.putdate = putdate;
    }

    public Notice(int id, String teano, String content, Date putdate) {
        this.id = id;
        this.teano = teano;
        this.content = content;
        this.putdate = putdate;
    }
}
