package com.example.school.adminPage.data;

import org.litepal.crud.DataSupport;



public class StudentData extends DataSupport{


    private TeacherData teacherData;

    private ParentData parentData;

    private int id;

    private String studentName;

    private String studentAge;

    private String studentActivity;

    public StudentData(int id){}

    public ParentData getParentData() {
        return parentData;
    }

    public void setParentData(ParentData parentData) {
        this.parentData = parentData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TeacherData getTeacherData() {
        return teacherData;
    }

    public void setTeacherData(TeacherData teacherData) {
        this.teacherData = teacherData;
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
