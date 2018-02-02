package com.example.school.adminPage.presentation.model;

import javax.inject.Inject;

/**
 * Created by xiecy on 2017/12/27.
 */

public class StudentModel {

    private TeacherModel teacherModel;

    private int id;

    private String studentName;

    private String studentAge;

    private String studentActivity;

    private ParentModel parentModel;

    @Inject
    public StudentModel(int id){}

    public ParentModel getParentModel() {
        return parentModel;
    }

    public void setParentModel(ParentModel parentModel) {
        this.parentModel = parentModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TeacherModel getTeacherModel() {
        return teacherModel;
    }

    public void setTeacherModel(TeacherModel teacherModel) {
        this.teacherModel = teacherModel;
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
