package com.example.school.dao;

import org.litepal.crud.DataSupport;

/**
 * Created by xiecy on 2017/12/14.
 */

public class Parent extends DataSupport{

    private Student student;

    private int id;

    private String account;

    private String password;


    private int Authority=1;

    public int getAuthority() {
        return Authority;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
