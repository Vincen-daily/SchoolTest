package com.example.school.adminPage.data;

import com.example.school.adminPage.presentation.model.StudentModel;
import com.example.school.dao.Student;

/**
 * Created by xiecy on 2017/12/28.
 */

public class ParentData {

    private int id;

    private StudentData studentData;

    private String account;

    private String password;

    private int Authority = 1;

    public ParentData(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentData getStudentData() {
        return studentData;
    }

    public void setStudentData(StudentData studentData) {
        this.studentData = studentData;
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

    public int getAuthority() {
        return Authority;
    }

    public void setAuthority(int authority) {
        Authority = authority;
    }
}
