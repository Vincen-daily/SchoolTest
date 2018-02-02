package com.example.school.adminPage.presentation;

import com.example.school.adminPage.data.StudentData;
import com.example.school.adminPage.presentation.base.BasePresenter;
import com.example.school.adminPage.presentation.model.StudentModel;
import com.example.school.adminPage.presentation.view.BaseView;

import java.util.List;

/**
 * Created by xiecy on 2017/12/20.
 */

public interface IPresenterAdminPage extends BasePresenter{

        interface View extends BaseView {

            void showDataInfo();

        }


        List<StudentModel> getDataSuccess();

        String update(int id,String name,int teacher,String message);

        void delete(int id);

        void getData(String message);

        List<StudentModel>  queryByTeacherId(int id);
}
