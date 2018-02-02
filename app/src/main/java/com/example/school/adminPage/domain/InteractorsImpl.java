package com.example.school.adminPage.domain;

import com.example.school.adminPage.data.StudentData;
import com.example.school.adminPage.data.mapper.StudentDataMapper;
import com.example.school.adminPage.data.repository.RepositoryInterface;
import com.example.school.adminPage.domain.model.UserEntity;


import java.util.List;

/**
 * Created by xiecy on 2017/12/25.
 */

public class InteractorsImpl implements Interactors {

    private RepositoryInterface repositoryInterface;

    private StudentDataMapper studentDataMapper;

    @Override
    public List<UserEntity> getData() {


        return studentDataMapper.transformToUserEntity(repositoryInterface.getData());

    }

    @Override
    public void update(int id, String name, int teacher) {
        repositoryInterface.update(id,name,teacher);
    }

    @Override
    public void delete(int id) {
        repositoryInterface.delete(id);
    }

    @Override
    public List<UserEntity> queryByTeacher(int id) {
         return  studentDataMapper.transformToUserEntity(repositoryInterface.queryByTeacher(id));
    }


}
