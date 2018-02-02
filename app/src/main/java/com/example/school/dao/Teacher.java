package com.example.school.dao;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/11/29.
 */

public class Teacher extends DataSupport {

    private List<Student> studentList = new ArrayList<Student>();

    private int id;

    private String teacherName;

    private String teacherPassword;

    private int Authority=2;

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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> students) {
        this.studentList = students;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }
}
