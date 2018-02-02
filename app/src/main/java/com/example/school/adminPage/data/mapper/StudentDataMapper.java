package com.example.school.adminPage.data.mapper;

import com.example.school.adminPage.data.StudentData;
import com.example.school.adminPage.domain.model.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by xiecy on 2017/12/27.
 */
@Singleton
public class StudentDataMapper {

    //teacher parent convert???

    @Inject
    StudentDataMapper() {
    }

    /**
     * Transform a {@link StudentData} into an {@link UserEntity}.
     *
     * @param studentData Object to be transformed.
     * @return {@link UserEntity} if valid {@link StudentData} otherwise null.
     */
    public UserEntity transformToUserEntity(StudentData studentData) {
        UserEntity userEntity = null;
        if (studentData != null) {
            userEntity = new UserEntity(studentData.getId());
            userEntity.setParentAccount(studentData.getParentData().getAccount());
            userEntity.setParentPassword(studentData.getParentData().getPassword());
            userEntity.setTeacherAccount(studentData.getTeacherData().getTeacherName());
            userEntity.setTeacherPassword(studentData.getTeacherData().getTeacherPassword());
            userEntity.setStudentName(studentData.getStudentName());
            userEntity.setStudentAge(studentData.getStudentAge());
            userEntity.setStudentActivity(studentData.getStudentActivity());
            userEntity.setAuthority(studentData.getParentData().getAuthority());
            userEntity.setAuthority(studentData.getTeacherData().getAuthority());
        }
        return userEntity;
    }

    /**
     * Transform a {@link UserEntity} into an {@link StudentData}.
     *
     * @param userEntity Object to be transformed.
     * @return {@link StudentData} if valid {@link UserEntity} otherwise null.
     */
    public StudentData transformToStudentData(UserEntity userEntity) {
        StudentData studentData = null;
        if (userEntity != null) {
            studentData = new StudentData(userEntity.getId());
            studentData.getParentData().setAccount(userEntity.getParentAccount());
            studentData.getParentData().setPassword(userEntity.getParentPassword());
            studentData.getParentData().setAuthority(userEntity.getAuthority());
            studentData.getTeacherData().setTeacherName(userEntity.getTeacherAccount());
            studentData.getTeacherData().setTeacherPassword(userEntity.getTeacherPassword());
            studentData.getTeacherData().setAuthority(userEntity.getAuthority());
            studentData.setStudentName(userEntity.getStudentName());
            studentData.setStudentAge(userEntity.getStudentAge());
            studentData.setStudentActivity(userEntity.getStudentActivity());

        }
        return studentData;
    }

    /**
     * Transform a List of {@link StudentData} into a Collection of {@link UserEntity}.
     *
     * @param studentDataCollection Object Collection to be transformed.
     * @return {@link UserEntity} if valid {@link StudentData} otherwise null.
     */
    public List<UserEntity> transformToUserEntity(Collection<StudentData> studentDataCollection) {
        final List<UserEntity> userEntityList = new ArrayList<>(20);
        for (StudentData studentData : studentDataCollection) {
            final UserEntity userEntity = transformToUserEntity(studentData);
            if (userEntity != null) {
                userEntityList.add(userEntity);
            }
        }
        return userEntityList;
    }

    /**
     * Transform a List of {@link UserEntity} into a Collection of {@link StudentData}.
     *
     * @param userEntityCollection Object Collection to be transformed.
     * @return {@link StudentData} if valid {@link UserEntity} otherwise null.
     */
    public List<StudentData> transformToStudentData(Collection<UserEntity> userEntityCollection) {
        final List<StudentData> studentDataList = new ArrayList<>(20);
        for (UserEntity userEntity : userEntityCollection) {
            final StudentData studentData = transformToStudentData(userEntity);
            if (studentData != null) {
                studentDataList.add(studentData);
            }
        }
        return studentDataList;
    }
}