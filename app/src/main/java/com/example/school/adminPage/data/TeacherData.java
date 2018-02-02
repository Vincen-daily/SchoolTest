package com.example.school.adminPage.data;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;



public class TeacherData extends DataSupport{

    private List<StudentData> studentDataList = new ArrayList<StudentData>();

    private int id;

    private String teacherName;

    private String teacherPassword;

    private int Authority=2;

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

    public List<StudentData> getStudentDataList() {
        return studentDataList;
    }

    public void setStudentDataList(List<StudentData> studentDataList) {
        this.studentDataList = studentDataList;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
