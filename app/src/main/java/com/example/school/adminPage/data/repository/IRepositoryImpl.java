package com.example.school.adminPage.data.repository;

import android.content.ContentValues;

import com.example.school.adminPage.data.StudentData;
import com.example.school.adminPage.data.TeacherData;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

/**
 * Created by xiecy on 2017/12/25.
 */

public class IRepositoryImpl implements RepositoryInterface {
    @Override
    public List<StudentData> getData() {

        Connector.getDatabase();

        return DataSupport.findAll(StudentData.class);

    }

    @Override
    public void update(int id, String name, int teacherId) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentName", name);
        contentValues.put("teacher_id", teacherId);
        DataSupport.update(StudentData.class, contentValues, id);
    }

    @Override
    public void delete(int id) {
        DataSupport.delete(StudentData.class,id);
    }

    @Override
    public List<StudentData> queryByTeacher(int id) {

        TeacherData teacherData = DataSupport.find(TeacherData.class, id, true);
        List<StudentData> studentData = teacherData.getStudentDataList();
        return studentData;
    }
}
