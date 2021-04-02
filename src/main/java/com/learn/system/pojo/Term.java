package com.learn.system.pojo;

public class Term {

    String term;

    public Term() {
    }

    public Term(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Term{" +
                "term='" + term + '\'' +
                '}';
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
