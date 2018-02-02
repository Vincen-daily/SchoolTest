package com.example.school.adminPage.presentation.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/27.
 */

public class TeacherModel {

    private List<StudentModel> studentModelList = new ArrayList<StudentModel>();

    private int id;

    private String teacherName;

    private String teacherPassword;

    private int Authority=2;

    public TeacherModel(int id) {
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public List<StudentModel> getStudentModelList() {
        return studentModelList;
    }

    public void setStudentModelList(List<StudentModel> studentModelList) {
        this.studentModelList = studentModelList;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
