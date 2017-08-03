package com.example.wendy.reportcard;

/**
 * Created by Wendy on 2017/07/27.
 */

public class Student {
    private String names;
    private String surname;
    private String grade;
    private String mark1;
    private String mark2;
    private int total;
    private int average;
    private int id;

    public Student(String names, String surname, String grade, String mark1, String mark2, int tota, int avr) {
        this.names = names;
        this.surname = surname;
        this.grade = grade;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.total = tota;
        this.average = avr;
    }

    public Student() {
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMark1() {
        return mark1;
    }

    public void setMark1(String mark1) {
        this.mark1 = mark1;
    }

    public String getMark2() {
        return mark2;
    }

    public void setMark2(String mark2) {
        this.mark2 = mark2;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
