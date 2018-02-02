package com.example.school.dao;

import org.litepal.crud.DataSupport;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by xiecy on 2017/11/29.
 */

public class Student extends DataSupport{

    private Teacher teacher;

    private int id;

    private String studentName;

    private String studentAge;

    private String studentActivity;

    private Parent parent;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public List<Teacher> getTName(){
        return  DataSupport.select("teacherName").where("id>?","0").find(Teacher.class);
    }
    public int getTeacherId(){
        return  DataSupport.where("id=?", String.valueOf(id)).findFirst(Student.class,true).getTeacher().getId();
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
}
