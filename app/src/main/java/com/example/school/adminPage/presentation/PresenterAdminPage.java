package com.example.school.adminPage.presentation;


import com.example.school.adminPage.data.StudentData;
import com.example.school.adminPage.domain.Interactors;
import com.example.school.adminPage.domain.InteractorsImpl;
import com.example.school.adminPage.domain.model.UserEntity;
import com.example.school.adminPage.presentation.mapper.StudentModelMapper;
import com.example.school.adminPage.presentation.model.StudentModel;
import com.example.school.adminPage.presentation.view.AdminAdapter;
import com.example.school.adminPage.data.repository.IRepositoryImpl;
import com.example.school.adminPage.data.repository.RepositoryInterface;
import com.example.school.dao.Student;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by xiecy on 2017/12/20.
 */

public class PresenterAdminPage implements IPresenterAdminPage {

    IPresenterAdminPage.View view;

    Interactors interactors= new InteractorsImpl();


    List<Student> studentList = new ArrayList<>();

    private AdminAdapter adminAdapter;

    private StudentModelMapper studentModelMapper;

    RepositoryInterface repositoryInterface=new IRepositoryImpl();

    @Inject
    public PresenterAdminPage(){}

    public void setView (IPresenterAdminPage.View view) {

        this.view = view;


    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public List<StudentModel> getDataSuccess() {

            return studentModelMapper.transformToStudentModel(interactors.getData());

    }

    @Override
    public String update(int id, String name, int teacher,String message) {
        if (id==0||name==null||teacher==0){
            message="请输入完整信息！";
        }else {

            interactors.update(id, name,teacher);
            message="修改成功！";
        }
        return message;
    }

    @Override
    public void delete(int id) {
        interactors.delete(id);
    }

    @Override
    public void getData(String message){
        if (getDataSuccess()!=null){
           view.showDataInfo();
        }else {
            view.showError(message);
        }
    }

    @Override
    public List<StudentModel> queryByTeacherId(int id) {
        return studentModelMapper.transformToStudentModel(interactors.queryByTeacher(id));
    }
}
