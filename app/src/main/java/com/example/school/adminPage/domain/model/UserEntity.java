package com.example.school.adminPage.domain.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/28.
 */

public class UserEntity {

    private int id;

    private String studentName;

    private String studentAge;

    private String studentActivity;

    private String parentAccount;

    private String parentPassword;

    private String teacherAccount;

    private String teacherPassword;

    private int Authority;

    public UserEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(String studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentActivity() {
        return studentActivity;
    }

    public void setStudentActivity(String studentActivity) {
        this.studentActivity = studentActivity;
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount;
    }

    public String getParentPassword() {
        return parentPassword;
    }

    public void setParentPassword(String parentPassword) {
        this.parentPassword = parentPassword;
    }

    public String getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(String teacherAccount) {
        this.teacherAccount = teacherAccount;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public int getAuthority() {
        return Authority;
    }

    public void setAuthority(int authority) {
        Authority = authority;
    }
}
