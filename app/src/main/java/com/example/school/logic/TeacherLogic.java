package com.example.school.logic;

import com.example.school.dao.Teacher;

import java.util.List;

/**
 * Created by xiecy on 2017/12/08.
 */

public interface TeacherLogic {

   void insert(String name,String password);

   List<Teacher> queryByNameAndPassword(String name,String password);

   int getAuthority(String name,String password);

   String getTeacherName(String account,String password);

}
