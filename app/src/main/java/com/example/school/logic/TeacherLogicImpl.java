package com.example.school.logic;


import com.example.school.dao.Teacher;
import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/08.
 */

public class TeacherLogicImpl implements TeacherLogic {

    List<Teacher> teacherList = new ArrayList<>();

    @Override
    public void insert(String name, String password) {
        Teacher teacher = new Teacher();
        teacher.setTeacherName(name);
        teacher.setTeacherPassword(password);
        teacher.save();
    }

    @Override
    public List<Teacher> queryByNameAndPassword(String name, String password) {
        teacherList = DataSupport.where("teacherName=?", name).where("teacherPassword=?", password).find(Teacher.class);
        return teacherList;
    }

    @Override
    public int getAuthority(String name, String password) {
        return DataSupport.where("teacherName=?", name).where("teacherPassword=?", password).findFirst(Teacher.class).getAuthority();
    }

    @Override
    public String getTeacherName(String account, String password) {
        return DataSupport.where("teacherName=?",account).where("teacherPassword=?",password).findFirst(Teacher.class).getTeacherName();
    }
}
