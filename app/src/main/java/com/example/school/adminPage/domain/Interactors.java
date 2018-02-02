package com.example.school.adminPage.domain;

import com.example.school.adminPage.data.StudentData;
import com.example.school.adminPage.domain.model.UserEntity;

import java.util.List;

/**
 * Created by xiecy on 2017/12/25.
 */

public interface Interactors {


    List<UserEntity> getData();

    void update(int id ,String name ,int teacher);

    void delete(int id);

    List<UserEntity> queryByTeacher(int id);
}
