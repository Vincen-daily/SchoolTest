package com.example.school.adminPage.presentation.mapper;

import com.example.school.adminPage.domain.model.UserEntity;
import com.example.school.adminPage.presentation.di.PerActivity;
import com.example.school.adminPage.presentation.model.StudentModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by xiecy on 2017/12/27.
 */

@PerActivity
public class StudentModelMapper {

    @Inject
    public StudentModelMapper() {
    }


    /**
     * Transform a {@link StudentModel} into an {@link UserEntity}.
     *
     * @param studentModel Object to be transformed.
     * @return {@link UserEntity} if valid {@link StudentModel} otherwise null.
     */
    public UserEntity transformToUserEntity(StudentModel studentModel) {
        UserEntity userEntity = null;
        if (studentModel != null) {
            userEntity = new UserEntity(studentModel.getId());
            userEntity.setParentAccount(studentModel.getParentModel().getAccount());
            userEntity.setParentPassword(studentModel.getParentModel().getPassword());
            userEntity.setTeacherAccount(studentModel.getTeacherModel().getTeacherName());
            userEntity.setTeacherPassword(studentModel.getTeacherModel().getTeacherPassword());
            userEntity.setStudentName(studentModel.getStudentName());
            userEntity.setStudentAge(studentModel.getStudentAge());
            userEntity.setStudentActivity(studentModel.getStudentActivity());
            userEntity.setAuthority(studentModel.getParentModel().getAuthority());
            userEntity.setAuthority(studentModel.getTeacherModel().getAuthority());
        }
        return userEntity;
    }

    /**
     * Transform a {@link UserEntity} into an {@link StudentModel}.
     *
     * @param userEntity Object to be transformed.
     * @return {@link UserEntity}.
     */
    public StudentModel transformToStudentModel(UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final StudentModel studentModel = new StudentModel(userEntity.getId());
        studentModel.getParentModel().setAccount(userEntity.getParentAccount());
        studentModel.getParentModel().setPassword(userEntity.getParentPassword());
        studentModel.getParentModel().setAuthority(userEntity.getAuthority());
        studentModel.getTeacherModel().setTeacherName(userEntity.getTeacherAccount());
        studentModel.getTeacherModel().setTeacherPassword(userEntity.getTeacherPassword());
        studentModel.getTeacherModel().setAuthority(userEntity.getAuthority());
        studentModel.setStudentName(userEntity.getStudentName());
        studentModel.setStudentAge(userEntity.getStudentAge());
        studentModel.setStudentActivity(userEntity.getStudentActivity());

        return studentModel;
    }

    /**
     * Transform a List of {@link StudentModel} into a Collection of {@link UserEntity}.
     *
     * @param studentModelCollection Object Collection to be transformed.
     * @return {@link UserEntity} if valid {@link StudentModel} otherwise null.
     */
    public List<UserEntity> transformToUserEntity(Collection<StudentModel> studentModelCollection) {
        final List<UserEntity> userEntityList = new ArrayList<>(20);
        for (StudentModel studentModel : studentModelCollection) {
            final UserEntity userEntity = transformToUserEntity(studentModel);
            if (userEntity != null) {
                userEntityList.add(userEntity);
            }
        }
        return userEntityList;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link StudentModel}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link StudentModel} if valid {@link UserEntity} otherwise null.
     */
    public List<StudentModel> transformToStudentModel(Collection<UserEntity> userEntityCollection) {
        final List<StudentModel> studentModelList = new ArrayList<>(20);
        for (UserEntity userEntity : userEntityCollection) {
            final StudentModel studentModel = transformToStudentModel(userEntity);
            if (studentModel != null) {
                studentModelList.add(studentModel);
            }
        }
        return studentModelList;
    }
}
