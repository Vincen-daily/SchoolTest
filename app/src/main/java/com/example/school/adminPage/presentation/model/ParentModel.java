package com.example.school.adminPage.presentation.model;

/**
 * Created by xiecy on 2017/12/28.
 */

public class ParentModel {

    private StudentModel studentModel;

    private int id;

    private String account;

    private String password;

    private int Authority=1;

    public StudentModel getStudentModel() {
        return studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }

    public void setAuthority(int authority) {
        Authority = authority;
    }

    public int getAuthority() {
        return Authority;
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
