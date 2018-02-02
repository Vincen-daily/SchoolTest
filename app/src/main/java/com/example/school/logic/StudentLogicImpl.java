package com.example.school.logic;

import android.content.ContentValues;
import android.provider.ContactsContract;

import com.example.school.dao.Parent;
import com.example.school.dao.Student;
import com.example.school.dao.Teacher;
import com.example.school.view.AdminAdapter;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiecy on 2017/12/08.
 */

public class StudentLogicImpl implements StudentLogic {

    List<Student> studentList = new ArrayList<>();

    List<Parent> parentList = new ArrayList<>();

    List<Teacher> teacherList = new ArrayList<>();

    Student student;

    Parent parent;

    Teacher teacher;

    @Override
    public List<Student> queryAll() {
        studentList = DataSupport.findAll(Student.class);
        return studentList;
    }

    @Override
    public void update(int id, String name, int teacherId) {

//        studentList=DataSupport.where("id=?", String.valueOf(id)).find(StudentEntity.class);
//        student=new StudentEntity();
//        teacherList=DataSupport.where("id=?", String.valueOf(teacherId)).find(TeacherEntity.class);
//        teacherList.set(teacherId,);
//        teacher.setStudentEntityList(studentList);
//        student.setTeacherEntity(teacher);
//        student.save();
//        teacher.save();
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentName", name);
        contentValues.put("teacher_id", teacherId);
        DataSupport.update(Student.class, contentValues, id);
    }

    @Override
    public void delete(int id) {
        DataSupport.delete(Student.class, id);
    }

    @Override
    public List<Student> queryByTeacherId(int id) {
        Teacher teacher = DataSupport.find(Teacher.class, id, true);
        List<Student> studentList = teacher.getStudentList();
        return studentList;
    }

    @Override
    public void insert(String account, String password, String name, String age) {
        Connector.getDatabase();
        student = new Student();
        parent = new Parent();
        parent.setAccount(account);
        parent.setPassword(password);
        student.setStudentAge(age);
        student.setStudentName(name);
        student.save();
        parent.setStudent(student);
        parent.save();
    }

    @Override
    public void updateById(int id, String activity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentActivity", activity);
        DataSupport.update(Student.class, contentValues, id);
    }


    @Override
    public List<Parent> queryByNameAndPassword(String name, String password) {
        return DataSupport.where("account=?", name).where("password=?", password).find(Parent.class);
    }

    @Override
    public int queryId(String account, String password) {
        return DataSupport.where("account=?and password=?", account,password).findFirst(Parent.class,true).getStudent().getId();

    }

    @Override
    public String queryStudentName(int id) {
        return DataSupport.select("studentName").where("id=?", String.valueOf(id)).findFirst(Student.class).getStudentName();
    }

    @Override
    public String queryStudentAge(int id) {
        return DataSupport.select("studentAge").where("id=?", String.valueOf(id)).findFirst(Student.class).getStudentAge();
    }

    @Override
    public String queryStudentActivity(int id) {
        return DataSupport.select("studentActivity").where("id=?", String.valueOf(id)).findFirst(Student.class).getStudentActivity();
    }

    @Override
    public int getAuthority(String account, String password) {
        int authority;
        parentList = DataSupport.where("account=? and password=?", account, password).find(Parent.class);
        teacherList = DataSupport.where("teacherName=? and teacherPassword=?", account, password).find(Teacher.class);
        if (parentList.size() != 0 && teacherList.size() == 0) {
            authority = 1;
        } else if (parentList.size() == 0 && teacherList.size() != 0) {
            authority = 2;
        } else {
            authority = 3;
        }
        return authority;
    }

    @Override
    public String getParentName(String account, String password) {
        return DataSupport.where("account=? and password=?", account, password).
                findFirst(Parent.class, true).getStudent().getStudentName();
    }
}
