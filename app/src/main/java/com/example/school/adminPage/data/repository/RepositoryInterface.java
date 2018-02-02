package com.example.school.adminPage.data.repository;

import com.example.school.adminPage.data.StudentData;

import java.util.List;

/**
 * Created by xiecy on 2017/12/25.
 */

public interface RepositoryInterface {

    List<StudentData> getData();

    void update(int id, String name, int teacherId);

    void delete(int id);

    List<StudentData> queryByTeacher(int id);

}
