package com.learn.system.pojo;

public class Teach {
    String teano;
    String teaname;

    public Teach() {
    }

    @Override
    public String toString() {
        return "Teach{" +
                "teano='" + teano + '\'' +
                ", teaname='" + teaname + '\'' +
                '}';
    }


    public String getTeaname() {
        return teaname;
    }

    public void setTeaname(String teaname) {
        this.teaname = teaname;
    }

    public void setTeano(String teano) {
        this.teano = teano;
    }

    public Teach(String teano) {
        this.teano = teano;
    }

    public Teach(String teano, String teaname) {
        this.teano = teano;
        this.teaname = teaname;
    }
}
