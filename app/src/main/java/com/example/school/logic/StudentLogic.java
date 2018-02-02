package com.example.school.logic;

import com.example.school.dao.Parent;
import com.example.school.dao.Student;

import java.util.List;

/**
 * Created by xiecy on 2017/12/08.
 */

public interface StudentLogic {

     List<Student> queryAll();

     void update(int id,String name,int teacherId);

     void delete(int id);

     List<Student> queryByTeacherId(int id);

     void insert(String account ,String password,String name,String age);

     void updateById(int id,String activity);

     List<Parent>queryByNameAndPassword(String name, String password);

     int queryId(String account,String password);

     String queryStudentName(int id);

     String queryStudentAge(int id);

     String queryStudentActivity(int id);

     int getAuthority(String account,String password);

     String  getParentName(String account ,String password);
}
